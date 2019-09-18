package DungeonWorld;

import java.util.ArrayList;
import java.util.Random;

public class Movement {

	public static void turnMovement(String command, Map gameMap) {

		moveEnemies(gameMap, 1);
		movePlayer(command, gameMap);

	}

	public static void movePlayer(String command, Map gameMap) {
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

			if (isThereAnyEnemy(currentX, currentY, gameMap)) {
				gameMap.getCharacterList().killCharacter(whichCreature(currentX, currentY, gameMap));
				gameMap.reduceVampire();
			}
		}

		gameMap.reduceCounter();
	}

	public static boolean isThereAnyEnemy(int givenX, int givenY, Map gameMap) {

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

	public static void moveEnemies(Map gameMap, int steps) {
		ArrayList<Character> list = gameMap.getCharacterList().getList();
		Random rand = new Random();
		int randomOption = 0;
		int enemyX = 0;
		int enemyY = 0;

		for (int i = 1; i < list.size(); i++) {

			for (int j = 0; j < list.get(i).getSteps(); j++) {

				randomOption = rand.nextInt(4);
				enemyX = list.get(i).getX();
				enemyY = list.get(i).getY();

				if (randomOption == 0) { // STAY IN THE SAME PLACE

				} else if (randomOption == 1) { // 1 LEFT
					if ((!isGoingOutOfMap(enemyX, -1, gameMap.getWidth())
							&& (!isThereAnyEnemy(enemyX - 1, enemyY, gameMap)))) {
						enemyX = enemyX - 1;
					}
				} else if (randomOption == 2) { // 1 RIGHT
					if ((!isGoingOutOfMap(enemyX, 1, gameMap.getWidth())
							&& (!isThereAnyEnemy(enemyX + 1, enemyY, gameMap)))) {
						enemyX = enemyX + 1;
					}
				} else if (randomOption == 3) { // 1 UP
					if ((!isGoingOutOfMap(enemyY, 1, gameMap.getHeight())
							&& (!isThereAnyEnemy(enemyX, enemyY + 1, gameMap)))) {
						enemyY = enemyY + 1;
					}
				} else if (randomOption == 4) { // 1 DOWN
					if ((!isGoingOutOfMap(enemyY, -1, gameMap.getHeight())
							&& (!isThereAnyEnemy(enemyX, enemyY - 1, gameMap)))) {
						enemyY = enemyY - 1;
					}
				}

				list.get(i).setX(enemyX);
				list.get(i).setY(enemyY);
			}

		}
	}
}
