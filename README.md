# Pong Game (Clone)
A Java Pong clone with single-player (vs AI) and local two-player modes, built with Java Swing.

Made by **Ervin Lepic** 
 
---

## Features

- Single-player mode with Easy / Medium / Hard AI difficulty
- Local two-player mode (same keyboard)
- Score modes: Best of 3, Best of 5, Best of 10
- Ball speeds up every 5 paddle bounces
- Options screen with adjustable music and sound effects volume
- Pause menu with Resume, Reset, Options, and Main Menu
---
## Want to try it out?

## Requirements

- Java 17+ (or Java 8+ should work fine)
- Any IDE that supports Java (IntelliJ IDEA, Eclipse, VS Code with Java extension)
- No external libraries required — uses only Java's built-in `javax.swing` and `javax.sound`
---

## How to Run

### Option A — Run from an IDE (Recommended)
1. Clone or download this repository.
2. Open the project in your IDE of choice.
3. Locate `Main.java` (in the root or `lepi.gamedev` package).
4. Run `Main.java` directly.

---

## Controls

### Single Player (Left Paddle = AI, Right Paddle = You)
| Action | Key |
|--------|-----|
| Move Up | `↑` Arrow |
| Move Down | `↓` Arrow |

### Two Player
| Player | Move Up | Move Down |
|--------|---------|-----------|
| Left Paddle | `W` | `S` |
| Right Paddle | `↑` Arrow | `↓` Arrow |

### General
| Action | Key |
|--------|-----|
| Pause / Unpause | `Escape` |
| Navigate menus | `W` / `S` or `↑` / `↓` |
| Confirm selection | `Enter` |
| Adjust volume | `A` / `D` or `←` / `→` |
 
---

## Project Structure

```
src/
└── lepi/gamedev/
    ├── Main.java               # Entry point
    ├── entity/
    │   ├── Entity.java         # Base class for all moving entities
    │   ├── Player.java         # Left paddle (AI in solo, human in 2P)
    │   ├── Player2.java        # Right paddle (always human)
    │   └── AIController.java   # AI logic for solo mode
    ├── game/
    │   ├── GamePanel.java      # Main game loop, state machine, rendering
    │   ├── KeyHandler.java     # Keyboard input handling
    │   ├── CollisionChecker.java  # Wall and paddle collision detection
    │   ├── UI.java             # All screen drawing (menus, scores, overlays)
    │   ├── Sound.java          # Audio loading and playback
    │   └── Difficulty.java     # Difficulty enum
    └── objects/
        ├── GameObject.java     # Base class for non-entity objects
        ├── Ball.java           # Ball movement, speed, difficulty values
        ├── WallUp.java         # Top boundary wall
        ├── WallDown.java       # Bottom boundary wall
        └── MiddleLine.java     # Decorative centre dashed line
sound/
    ├── Booty-Shake-Robot.wav   # Background music
    ├── collision-sound.wav     # Ball hit sound effect
    ├── scroll_button.wav       # Menu navigation sound
    └── select_button.wav       # Menu confirm sound
```
 
---

## Game States

The game uses an integer state machine in `GamePanel`:

| State | Value | Description |
|-------|-------|-------------|
| `titleState` | 0 | Main menu and all sub-menus |
| `playState` | 1 | Active gameplay |
| `pauseState` | 2 | Paused overlay |
| `optionsState` | 3 | Volume options (accessible from pause too) |
| `endState` | 4 | Game over screen |
