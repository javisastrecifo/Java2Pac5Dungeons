package DungeonWorld;

import java.util.ArrayList;
import java.util.Random;

public class Movement {

	public static void turnMovement(String command, Map gameMap) {

		moveVampires(gameMap);

		Character player = gameMap.getCharacterList().getList().get(0);
		int currentX = player.getX();
		int currentY = player.getY();

		for (int m = 0; m < command.length(); m++) {

			if (command.charAt(m) == 'a') {
				if ((!isGoingOutOfMap(currentX, -1, gameMap.getWidth()))) {
					currentX = currentX - 1;
				}

			} else if (command.charAt(m) == 'd') {
				if (!isGoingOutOfMap(currentX, 1, gameMap.getWidth())) {
					currentX = currentX + 1;
				}

			} else if (command.charAt(m) == 'w') {
				if (!isGoingOutOfMap(currentY, -1, gameMap.getHeight())) {
					currentY = currentY - 1;
				}

			} else if (command.charAt(m) == 's') {
				if (!isGoingOutOfMap(currentY, 1, gameMap.getHeight())) {
					currentY = currentY + 1;
				}
			}

			player.setX(currentX);
			player.setY(currentY);

			if (isThereAnyCreature(currentX, currentY, gameMap)) {
				gameMap.getCharacterList().killCharacter(whichCreature(currentX, currentY, gameMap));
				gameMap.reduceVampire();
			}
		}

		gameMap.reduceCounter();
	}

	public static boolean isThereAnyCreature(int givenX, int givenY, Map gameMap) {

		ArrayList<Character> list = gameMap.getCharacterList().getList();

		for (int i = 1; i < list.size(); i++) {
			if ((list.get(i).getX() == givenX) && (list.get(i).getY() == givenY)) {
				return true;
			}
		}
		return false;
	}

	public static int whichCreature(int givenX, int givenY, Map gameMap) {

		ArrayList<Character> list = gameMap.getCharacterList().getList();

		for (int i = 1; i < list.size(); i++) {
			if ((list.get(i).getX() == givenX) && (list.get(i).getY() == givenY)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isGoingOutOfMap(int playerPosition, int futureMovement, int mapLimit) {
		if ((playerPosition + futureMovement >= 0) && (playerPosition + futureMovement < mapLimit)) {
			return false;
		} else {
			return true;
		}
	}

	public static void moveVampires(Map gameMap) {
		ArrayList<Character> list = gameMap.getCharacterList().getList();
		Random rand = new Random();
		int randomOption = 0;
		int vampireX = 0;
		int vampireY = 0;

		for (int i = 1; i < list.size(); i++) {
			randomOption = rand.nextInt(4);
			vampireX = list.get(i).getX();
			vampireY = list.get(i).getY();

			if (randomOption == 0) {

			} else if (randomOption == 1) { // 1 LEFT
				if ((!isGoingOutOfMap(vampireX, -1, gameMap.getWidth()) && (isThereAnyCreature(vampireX, vampireY, gameMap)))) {
					vampireX = vampireX - 1;
				}
			} else if (randomOption == 2) { // 1 RIGHT
				if ((!isGoingOutOfMap(vampireX, -1, gameMap.getWidth()) && (isThereAnyCreature(vampireX, vampireY, gameMap)))) {
					vampireX = vampireX + 1;
				}
			} else if (randomOption == 3) { // 1 UP
				if ((!isGoingOutOfMap(vampireX, -1, gameMap.getWidth()) && (isThereAnyCreature(vampireX, vampireY, gameMap)))) {
					vampireY = vampireY - 1;
				}
			} else if (randomOption == 4) { // 1 DOWN
				if ((!isGoingOutOfMap(vampireX, -1, gameMap.getWidth()) && (isThereAnyCreature(vampireX, vampireY, gameMap)))) {
					vampireY = vampireY - 1;
				}
			}

			list.get(i).setX(vampireX);
			list.get(i).setY(vampireY);

		}
	}
}
