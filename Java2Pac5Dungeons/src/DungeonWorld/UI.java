package DungeonWorld;

import java.util.Scanner;

public class UI {

	public static void start() {
		Scanner reader = new Scanner(System.in);
		ElementsDB elements = new ElementsDB();
		Map gameMap = new Map (10, 10, 4, 15, false);

		System.out.println("VAMPIRE DUNGEON GAME\n********************\n\n");
		String command = "";
		gameMap.start(elements);
		
		while (true) {
			// print left moves
			// print positions
			// print map
			System.out.print("> ");
			command = reader.nextLine();
			if (!checkInPut(command)) {
				System.out.println("Invalid input");
			} else {
				// proceed with the commands
			}
		}

	}

	public static boolean checkInPut(String command) {
		for (int i = 0; i < command.length(); i++) {
			if (!checkCharacter(command.charAt(i))) {
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
}
