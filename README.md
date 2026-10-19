# CrystalPracticeBot-26.2
[![Minecraft Version](https://img.shields.io/badge/Minecraft-26.2-brightgreen.svg)](https://minecraft.net)
[![Paper](https://img.shields.io/badge/Paper-Required-orange.svg)](https://papermc.io)
[![Java](https://img.shields.io/badge/Java-25-blue.svg)](https://adoptium.net)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

A Minecraft plugin that spawns customizable practice bots for crystal PvP training. Perfect for servers that want to give players AI opponents to practice their combat skills.

## 🎯 Features

### Core Functionality
- **Spawn Practice Bots**: Create AI-controlled zombie bots for combat practice
- **Customizable Behavior**: Configure bot AI patterns and responses
- **Equipment Management**: Control bot armor, weapons, and items
- **Effect System**: Apply potion effects to bots for varied training scenarios
- **GUI Interface**: Menus for all bot configuration

### Bot Behaviors
- **Aggressive Mode**: Bot actively attacks the player
- **Defensive Mode**: Bot only fights back when the player's health is low
- **Stand Still Mode**: Bot stays stationary for target practice
- **Pearl to Owner**: Bot throws an ender pearl toward the player when too far away
- **Auto Totem**: Bot automatically holds totems of undying
- **Shield Usage**: Bot carries an enchanted shield in its off-hand

### Equipment Customization
- **Armor Sets**: Choose the armor material for each slot
- **Enchantments**: Pick the protection type (Protection, Blast, Projectile, Fire) per armor piece
- **Weapon**: Enchanted diamond sword by default

## 📋 Requirements

- **Minecraft Version**: 26.2
- **Server Software**: Paper, Purpur, or other Paper-based forks
- **Java Version**: 25
- **Permissions**: Op or `practicebot.admin` for admin commands

## 🚀 Installation

1. Download the latest `.jar` from [Releases](https://github.com/G1axCustoms/G1axCrystalPracticeBot/releases), or build it yourself (see below)
2. Place the `.jar` file in your server's `plugins` folder
3. Restart your server
4. Configure permissions if needed

## 🎮 Commands

| Command | Description | Permission | Usage |
|---------|-------------|------------|-------|
| `/spawnbot` | Spawn a practice bot | Default | `/spawnbot` |
| `/botmenu` | Open bot configuration menu | Default | `/botmenu` |
| `/removebot` | Remove your practice bot | Default | `/removebot` |
| `/removeallbots` | Remove all practice bots (Admin) | `practicebot.admin` | `/removeallbots` |

## 🔧 Permissions

```yaml
practicebot.admin:
  description: Allows access to admin commands
  default: op
```

## 📖 Usage Guide

1. Use `/spawnbot` to create your first practice bot
2. Use `/botmenu` to open the configuration interface
3. Customize the bot's behavior, equipment, and effects
4. Practice your PvP skills!
5. Use `/removebot` when finished

### Behavior Settings
- **Aggressive**: Bot pursues and attacks you
- **Defensive**: Bot only fights when you're below 50% health
- **Stand Still**: Bot remains motionless for target practice
- **Pearl to Owner**: Bot throws a pearl toward you if you get too far away
- **Auto Totem**: Bot holds totems of undying

### Equipment & Effects
- **Armor**: Chainmail, iron, golden, diamond, netherite (and turtle helmet) per slot
- **Enchantments**: Protection, Blast Protection, Projectile Protection, Fire Protection
- **Effects**: Invisibility, Speed, Jump Boost, Strength, Resistance, Absorption

## 🛠️ Building from Source

### Option 1: GitHub Actions (no local setup needed)

1. Fork this repo, or upload the project files to your own GitHub repo (`pom.xml` must be at the repo root, and the `.github/workflows/build.yml` file must be included)
2. Go to the **Actions** tab, select **Build plugin**, and click **Run workflow**. It also runs automatically on every push.
3. When the run finishes, open it and download the **G1axCrystalPracticeBot** artifact from the *Artifacts* section
4. Unzip it to get `G1axCrystalPracticeBot.jar` and put it in your server's `plugins` folder

### Option 2: Build locally

Requirements: **JDK 25** and **Maven**.

```bash
git clone https://github.com/G1axCustoms/G1axCrystalPracticeBot.git
cd G1axCrystalPracticeBot
mvn clean package
```

The jar will be at `target/G1axCrystalPracticeBot.jar`.

### Project Structure
```
src/main/java/dev/akatriggered/practicebot/
├── PracticeBotPlugin.java          # Main plugin class
├── bot/
│   ├── BotManager.java             # Bot management system
│   ├── PracticeBot.java            # Individual bot instance
│   ├── BotAI.java                  # AI behavior logic
│   ├── BotBehaviour.java           # Behavior configuration
│   ├── BotEffects.java             # Potion effects management
│   └── BotEquipment.java           # Equipment handling
├── commands/
│   ├── SpawnBotCommand.java        # Bot spawning command
│   ├── BotMenuCommand.java         # Menu opening command
│   ├── RemoveBotCommand.java       # Bot removal command
│   └── RemoveAllBotsCommand.java   # Admin removal command
├── gui/
│   ├── BotMenu.java                # Main configuration GUI
│   ├── ArmorGUI.java               # Armor configuration interface
│   ├── BehaviourGUI.java           # Behavior settings interface
│   ├── EffectGUI.java              # Effect management interface
│   └── EnchantGUI.java             # Enchantment configuration
└── util/
    ├── PlayerData.java             # Player data management
    ├── ItemBuilder.java            # Item creation utility
    ├── ArmorFactory.java           # Armor set creation
    ├── NBTUtil.java                # Persistent data handling
    └── UsageStats.java             # Usage statistics tracking
```

## 🐛 Bug Reports & Feature Requests

Found a bug or have a feature request? Create an issue on the [GitHub Issues](https://github.com/G1axCustoms/G1axCrystalPracticeBot/issues) page.

When reporting bugs, please include:
- Minecraft version
- Server software and version
- Plugin version
- Steps to reproduce the issue
- Any error messages from the console

## 🤝 Contributing

Contributions are welcome! Feel free to submit pull requests or open issues for discussion.

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built for the Minecraft PvP community
- Original plugin by AkaTriggered for the G1ax Customs community
- Updated for Paper 26.2
------------------------------------------------------
