# Clear Despawn — Modern Port for Minecraft 26.3 (Fabric)

![Mod loader: Fabric](https://img.shields.io/badge/modloader-Fabric-1976d2?style=for-the-badge)
![Minecraft: 26.3](https://img.shields.io/badge/Minecraft-26.3-green?style=for-the-badge)
![GitHub license](https://img.shields.io/github/license/Sekai0NI0itamio/ClearDespawn263?style=for-the-badge)

**Makes items blink before they despawn — so you never lose loot again.**

Clear Despawn makes dropped items visibly blink/flash as they approach
their despawn time, warning you to pick them up in time. No more
returning to a farm or battlefield to find your drops silently gone.

Now with a **modern port for Minecraft 26.3 (Fabric)**, rebuilt for
26.3's new render-state rendering pipeline (`ItemEntityRenderState`,
`extractRenderState`/`submit`) — the blink decision is captured when
the render state is extracted and applied when the item is submitted.

### What it does

- Items blink on/off when close to despawning (configurable start time)
- `urgentFlash` mode: blinking gets faster the closer the item is to despawning
- Client-side only — no server required

### Configuration

Config file: `config/itamio_cleardespawn.json` (created on first run).

- `flashStartTime` — seconds before despawn when blinking starts (default: `20`, range 0–300)
- `despawnTime` — total lifetime of dropped items in ticks (default: `6000`, i.e. 5 minutes)
- `urgentFlash` — faster blinking near despawn (default: `true`)

### Modern port notes (26.3)

- Renderer replacement rewritten for the render-state pipeline
- `EntityType.ITEM` lookup via registry id (the constant was renamed in 26.3)
- Java 25 · Fabric Loader 0.20.1+ · Fabric API 0.165.0+26.3
- Built and verified in CI via GitHub Actions

### Installation

1. Install Fabric Loader for Minecraft 26.3
2. Install Fabric API
3. Drop `cleardespawn263-*.jar` into your `mods` folder

### Original mod & credit

This is an unofficial modern port by **Itamio** of **ClearDespawn** by
**StrikerRockers-Mods (StrikerRocker)** — the original (3M+ downloads on
Modrinth, last updated for 1.20.2) has not been updated to 26.3.

- Original mod: https://modrinth.com/mod/cleardespawn
- Original source: https://github.com/StrikerRockers-Mods/ClearDespawn/
- License: MIT — see `LICENSE`

All credit for the original concept, design, and logic goes to
StrikerRocker and the StrikerRockers-Mods team. This port exists to
bring it to Minecraft 26.3. See `NOTICE`.
