import { existsSync, readdirSync, readFileSync, statSync } from "node:fs";
import { dirname, extname, resolve } from "node:path";
import { fileURLToPath } from "node:url";

const root = resolve(dirname(fileURLToPath(import.meta.url)), "..");
const ignoredDirectories = new Set([".git", "node_modules", "target"]);

function markdownFiles(directory) {
    return readdirSync(directory, { withFileTypes: true }).flatMap((entry) => {
        const path = resolve(directory, entry.name);
        if (entry.isDirectory()) {
            return ignoredDirectories.has(entry.name) ? [] : markdownFiles(path);
        }
        return extname(entry.name).toLowerCase() === ".md" ? [path] : [];
    });
}

function githubAnchors(markdown) {
    const anchors = new Set();
    const occurrences = new Map();
    let inFence = false;

    for (const line of markdown.split(/\r?\n/u)) {
        if (/^\s*```/u.test(line)) {
            inFence = !inFence;
            continue;
        }
        if (inFence) {
            continue;
        }

        const match = /^(#{1,6})\s+(.+?)\s*#*\s*$/u.exec(line);
        if (!match) {
            continue;
        }

        const plain = match[2]
                .replace(/<[^>]+>/gu, "")
                .replace(/!\[([^\]]*)\]\([^)]*\)/gu, "$1")
                .replace(/\[([^\]]+)\]\([^)]*\)/gu, "$1")
                .replace(/[`*_~]/gu, "");
        const base = plain
                .trim()
                .toLowerCase()
                .replace(/[^\p{L}\p{N}\s_-]/gu, "")
                .replace(/\s+/gu, "-");
        const count = occurrences.get(base) ?? 0;
        occurrences.set(base, count + 1);
        anchors.add(count === 0 ? base : `${base}-${count}`);
    }
    return anchors;
}

function destinations(markdown) {
    const values = [];
    const inline = /!?\[[^\]]*\]\(([^)\s]+)(?:\s+["'][^)]*)?\)/gu;
    const reference = /^\s*\[[^\]]+\]:\s*(\S+)/gmu;

    for (const pattern of [inline, reference]) {
        for (const match of markdown.matchAll(pattern)) {
            values.push(match[1].replace(/^<|>$/gu, ""));
        }
    }
    return values;
}

const files = markdownFiles(root);
const anchorCache = new Map(
        files.map((file) => [file, githubAnchors(readFileSync(file, "utf8"))]));
const failures = [];
let checked = 0;

for (const source of files) {
    const markdown = readFileSync(source, "utf8");
    for (const rawDestination of destinations(markdown)) {
        if (/^(?:https?:|mailto:|data:)/iu.test(rawDestination)) {
            continue;
        }

        const [rawPath, rawAnchor] = rawDestination.split("#", 2);
        let target = rawPath
                ? resolve(dirname(source), decodeURIComponent(rawPath))
                : source;

        if (existsSync(target) && statSync(target).isDirectory()) {
            target = resolve(target, "README.md");
        }

        checked++;
        if (!existsSync(target)) {
            failures.push(`${source}: ontbrekend bestand ${rawDestination}`);
            continue;
        }

        if (rawAnchor && extname(target).toLowerCase() === ".md") {
            const anchor = decodeURIComponent(rawAnchor).toLowerCase();
            const anchors = anchorCache.get(target)
                    ?? githubAnchors(readFileSync(target, "utf8"));
            if (!anchors.has(anchor)) {
                failures.push(`${source}: ontbrekend anker ${rawDestination}`);
            }
        }
    }
}

if (failures.length > 0) {
    console.error(failures.join("\n"));
    process.exitCode = 1;
} else {
    console.log(`Interne links in orde: ${checked} verwijzingen in ${files.length} Markdown-bestanden.`);
}
