---
name: mekasuit-build
description: Build this repository's Minecraft 1.12.2 Forge mod with the machine-local RetroFuturaGradle toolchain. Use when compiling, packaging, or validating a MekanismMoreMekaSuitModules JAR in this repository.
---

# Mekasuit Build

Run the repository-local `scripts/build.sh` from this skill directory. It uses `/opt/minecraft-tools`, keeps Gradle caches and downloaded build dependencies there, and builds offline after ensuring the FernFlower patch archive is present.

```bash
.codex/skills/mekasuit-build/scripts/build.sh
```

Pass additional Gradle arguments after the script when needed, for example:

```bash
.codex/skills/mekasuit-build/scripts/build.sh --rerun-tasks
```

The script does not change `gradle.properties` or the mod version. The normal artifact is written to `build/libs/`.
