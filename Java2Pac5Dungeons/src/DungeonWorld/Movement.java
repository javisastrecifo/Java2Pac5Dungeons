package DungeonWorld;

import java.util.ArrayList;
import java.util.Random;

public class Movement {

	private ArrayList<Character> characterList;

	public Movement(ArrayList<Character> charList) {
		this.characterList = charList;
	}

	public void eachTurn(String command, Map gameMap) {

		gameMap.getCharacterList().movements().moveEnemies(gameMap, 1);
		gameMap.getCharacterList().movements().movePlayer(command, gameMap);
	}

	public void movePlayer(String command, Map gameMap) {
		Character player = this.characterList.get(0);
		int currentX = player.getX();
		int currentY = player.getY();
		int futureX = 0;
		int futureY = 0;

		for (int m = 0; m < command.length(); m++) {

	
			if (command.charAt(m) == 'a') {
				if ((!isGoingOutOfMap(currentX, -1, gameMap.getWidth()))) {
					futureX = currentX - 1;
					futureY = currentY;
				}

			} else if (command.charAt(m) == 'd') {
				if (!isGoingOutOfMap(currentX, 1, gameMap.getWidth())) {
					futureX = currentX + 1;
					futureY = currentY;
				}

			} else if (command.charAt(m) == 'w') {
				if (!isGoingOutOfMap(currentY, -1, gameMap.getHeight())) {
					futureX = currentX;
					futureY = currentY - 1;
				}

			} else if (command.charAt(m) == 's') {
				if (!isGoingOutOfMap(currentY, 1, gameMap.getHeight())) {
					futureX = currentX;
					futureY = currentY + 1;
				}
			}

			if (isThereAnything(futureX, futureY, gameMap)) {
				if (this.characterList.get(elementIntID(futureX, futureY, gameMap)).getClass() == Vampire.class) {
					gameMap.getCharacterList().killCharacter(elementIntID(futureX, futureY, gameMap));
					gameMap.reduceVampireCount();
					currentX = futureX;
					currentY = futureY;
				} else {

				}
			} else {
				currentX = futureX;
				currentY = futureY;
			}
			player.setX(currentX);
			player.setY(currentY);
		}

		gameMap.reduceCounter();

	}

	public static boolean isThereAnything(int givenX, int givenY, Map gameMap) {

		ArrayList<Character> list = gameMap.getCharacterList().getList();

		for (int i = 1; i < list.size(); i++) {
			if ((list.get(i).getX() == givenX) && (list.get(i).getY() == givenY)) {
				return true;
			}
		}
		return false;
	}

	public static int elementIntID(int givenX, int givenY, Map gameMap) {

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

	public void moveEnemies(Map gameMap, int steps) {
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
							&& (!isThereAnything(enemyX - 1, enemyY, gameMap)))) {
						enemyX = enemyX - 1;
					}
				} else if (randomOption == 2) { // 1 RIGHT
					if ((!isGoingOutOfMap(enemyX, 1, gameMap.getWidth())
							&& (!isThereAnything(enemyX + 1, enemyY, gameMap)))) {
						enemyX = enemyX + 1;
					}
				} else if (randomOption == 3) { // 1 UP
					if ((!isGoingOutOfMap(enemyY, 1, gameMap.getHeight())
							&& (!isThereAnything(enemyX, enemyY + 1, gameMap)))) {
						enemyY = enemyY + 1;
					}
				} else if (randomOption == 4) { // 1 DOWN
					if ((!isGoingOutOfMap(enemyY, -1, gameMap.getHeight())
							&& (!isThereAnything(enemyX, enemyY - 1, gameMap)))) {
						enemyY = enemyY - 1;
					}
				}

				list.get(i).setX(enemyX);
				list.get(i).setY(enemyY);
			}

		}
	}

	public ArrayList<Character> getCharacterList() {
		return this.characterList;
	}
}
