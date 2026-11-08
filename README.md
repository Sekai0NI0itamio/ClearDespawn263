# ClearDespawn263

> **Unofficial port** of [ClearDespawn](https://modrinth.com/mod/cleardespawn) by StrikerRockers-Mods (author: StrikerRocker), updated for Minecraft 26.3 (Fabric). Original source: https://github.com/StrikerRockers-Mods/ClearDespawn/ (MIT, max Minecraft 1.20.2). All credit for the original concept, design, and logic goes to StrikerRocker and the StrikerRockers-Mods team. This port was created by Itamio because the original mod has not been updated to Minecraft 26.3. Code self-updated to current Fabric rendering APIs. See [NOTICE](./NOTICE) for licensing details.

ClearDespawn makes disappearing items blink/flash to warn players to pick them up before they despawn.

**Client-side only** — no server required.

## Configuration

Config file: `config/itamio_cleardespawn.json` (created on first run).

- `flashStartTime` — seconds before despawn when blinking starts (default: `20`, range 0–300)
- `despawnTime` — total lifetime of dropped items in ticks (default: `6000`, i.e. 5 minutes)
- `urgentFlash` — when true, items blink faster as they get closer to despawning (default: `true`)

## Requirements

- Minecraft 26.3
- Fabric Loader ≥ 0.20.1
- Fabric API
- Java 25
