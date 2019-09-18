package DungeonWorld;

import java.util.Scanner;

public class DungeonGame {

	private Scanner reader;
	private Map gameMap;

	public DungeonGame() {
		this.reader = new Scanner(System.in);
		this.gameMap = new Map(10, 10, 6, 15, true);
	}

	public void start() {

		this.gameMap.start();

		System.out.println("VAMPIRE DUNGEON GAME\n********************");
		String command = "";

		while (true) {
			if (!checkGameStatus()) {
				this.gameMap.print();
				break;
			}
			System.out.println("\nMovements: " + this.gameMap.getCounter() + "\n");
			this.gameMap.print();

			System.out.print("\nInsert movements: ");
			command = this.reader.nextLine();

			if (!checkInPut(command)) {

			} else {
				this.gameMap.getCharacterList().movements().eachTurn(command, gameMap);
				}
		}

	}

	public static boolean checkInPut(String command) {
		if (command.length() == 0) {
			return false;
		}
		for (int i = 0; i < command.length(); i++) {
			if (!checkCharacter(command.charAt(i))) {
				System.out.println("Invalid input");
				return false;
			}
		}
		return true;
	}

	public static boolean checkCharacter(char charact) {
		if ((charact == 'w') || (charact == 'd') || (charact == 's') || (charact == 'a')) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkGameStatus() {
		if (this.gameMap.getCounter() < 0) {
			this.gameMap.getCharacterList().killCharacter(0);
			System.out.println("*** YOU LOST! ***\n\n\n");
			return false;
		} else if (this.gameMap.getVampires() == 0) {
			System.out.println("*** YOU WIN!! ***\n\n\n");
			return false;
		} else {
			return true;
		}
	}
}
