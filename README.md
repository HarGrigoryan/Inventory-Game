# Item System Development Task

This project implements an **Item Upgrade System** in Java for a console-based game. The system allows display and upgrading of items based on their rarity.
The system assumes a predefined format for the item objects stored in the Items.txt file.
---

## Running Instructions

1. Compile the source files:
   ```bash
   javac *.java
   ```
2. Run the program, providing the path to the `Items.txt` file as a command-line argument:
   ```bash
   java Main "C:/Path/To/Items.txt"
   ```

Replace `"C:/Path/To/Items.txt"` with the actual path to the `Items.txt` file.

---

## Example `Items.txt` Format
```
8
Iron Sword Common null
Golden Bow Rare null
Silver Shield Great null
Golden Bow Rare null
Dragon Axe Epic 0 
Golden Bow Epic 1
Golden Bow Legendary null
Golden Bow Rare null
```

