package DungeonWorld;

public class Movement {

	public static void movePlayer(String command, Map gameMap) {

		int currentX = 0;
		int currentY = 0;
		Character player = gameMap.getElements().getList().get(0);

		for (int m = 0; m < command.length(); m++) {

			currentX = gameMap.getElements().getList().get(0).getX();
			currentY = gameMap.getElements().getList().get(0).getY();

			if (command.charAt(m) == 'a') {
				if (checkPosition(player.getX(), -1, gameMap.getWidth())) {
					player.setX(currentX - 1);
				}
			} else if (command.charAt(m) == 'd') {
				if (checkPosition(player.getX(), 1, gameMap.getWidth())) {
					player.setX(currentX + 1);
				}
			} else if (command.charAt(m) == 'w') {
				if (checkPosition(player.getY(), -1, gameMap.getHeight())) {
					player.setY(currentY - 1);
				}
			} else if (command.charAt(m) == 's') {
				if (checkPosition(player.getY(), 1, gameMap.getHeight())) {
					player.setY(currentY + 1);
				}
			}
		}
		gameMap.reduceCounter();
	}

	public static boolean checkPosition(int playerPosition, int movement, int mapLimit) {
		if ((playerPosition + movement >= 0) && (playerPosition + movement < mapLimit)) {
			return true;
		} else {
			return false;
		}
	}
}
