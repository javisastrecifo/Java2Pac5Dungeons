package DungeonWorld;

import java.util.Scanner;

public class UI {

	public static void start() {
		Scanner reader = new Scanner(System.in);
		ElementsDB elements = new ElementsDB();
		Map gameMap = new Map(10, 10, 4, 15, false);
		gameMap.start(elements);

		System.out.println("VAMPIRE DUNGEON GAME\n********************");
		String command = "";

		while (true) {
			if (!checkGameStatus(gameMap)) {
				break;
			}
			System.out.println("\nMovements: " + gameMap.getCounter() + "\n");
			gameMap.print(elements);

			System.out.print("\nInsert movements: ");
			command = reader.nextLine();

			if (!checkInPut(command)) {

			} else {
				Movement.movePlayer(command, elements, gameMap);
			}
		}

	}

	public static boolean checkInPut(String command) {
		if (command.length()==0) {
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

	public static boolean checkGameStatus(Map gameMap) {
		if ((gameMap.getVampires() == 0) || (gameMap.getCounter() == 0)) {
			System.out.println("*** YOU LOST! ***");
			return false;
		} else {
			return true;
		}
	}
}
