package homeworks;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4App {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static char[][] map;
    public static int mapWidth = 4;
    public static int mapHeight = 4;
    public static int mapCountLevel = 0;

    public static char player = '#';
    public static int playerHealth = 100;
    public static int playerPosX;
    public static int playerPosY;
    public static int playerCountStep = 0;
    public static boolean setRandomStartPosition = true;

    public static final int moveUp = 8;
    public static final int moveDown = 2;
    public static final int moveLeft = 4;
    public static final int moveRight = 6;
    public static final int moveLeftUpRightDownDiag = 7;
    public static final int moveRightDownLeftUpDiag = 3;
    public static final int moveLeftDownRightUpDiag = 1;
    public static final int moveRightUpLeftDownDiag = 9;
    public static final int exit = 0;

    public static char readyCell = '*';
    public static char emptyCell = '-';

    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++mapCountLevel;
            System.out.println("===== Game Start! Current LEVEL " + mapCountLevel);
            gameCycle();
        }
        System.out.println("===== Game Over! Count player steps: " + playerCountStep + ". Count ready level " + mapCountLevel);
    }

    public static void gameCycle() {
        createMap();
        createPlayer(setRandomStartPosition);

        while (true) {
            printMap();
            System.out.println("[Player info] > Health: " + playerHealth + ". Count steps: " + playerCountStep);
            changePositionPlayer();

            if (!isPlayerAlive()) {
                System.out.println("Player is Dead!");
                break;
            }

            if (isFullMap()) {
                System.out.println("Map is full");
                break;
            }
        }
    }

    public static void createMap() {
        map = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
            }
        }

        System.out.println("Create map > size " + mapWidth + "x" + mapHeight);
    }

    public static void printMap() {
        System.out.println("===== CURRENT MAP =====");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }

    public static void createPlayer(boolean randomPositionPlayer) {
        if (randomPositionPlayer) {
            playerPosX = randomRange(0, mapWidth - 1);
            playerPosY = randomRange(0, mapHeight - 1);
        } else {
            playerPosX = mapWidth / 2;
            playerPosY = mapHeight / 2;
        }
        map[playerPosY][playerPosX] = player;
    }

    public static void changePositionPlayer() {
        int currentX = playerPosX;
        int currentY = playerPosY;

        int playerMove;

        do {
            System.out.print("Enter your move (UP=" + moveUp +
                    " DOWN=" + moveDown +
                    " LEFT=" + moveLeft +
                    " RIGHT=" + moveRight +
                    " LDRU=" + moveLeftDownRightUpDiag +
                    " RULD=" + moveRightUpLeftDownDiag +
                    " LURD=" + moveLeftUpRightDownDiag +
                    " RDLU=" + moveRightDownLeftUpDiag + ") " +
                    " EXIT=" + exit + ">>> "
            );
            playerMove = scanner.nextInt();

            switch (playerMove) {
                case moveUp:
                    playerPosY -= 1;
                    break;
                case moveDown:
                    playerPosY += 1;
                    break;
                case moveLeft:
                    playerPosX -= 1;
                    break;
                case moveRight:
                    playerPosX += 1;
                    break;
                case moveLeftDownRightUpDiag:
                    playerPosX -= 1;
                    playerPosY += 1;
                    break;
                case moveRightUpLeftDownDiag:
                    playerPosX += 1;
                    playerPosY -= 1;
                    break;
                case moveRightDownLeftUpDiag:
                    playerPosX += 1;
                    playerPosY += 1;
                    break;
                case moveLeftUpRightDownDiag:
                    playerPosX -= 1;
                    playerPosY -= 1;
                    break;
                case exit:
                    System.out.println("The player has left the game.");
                    System.exit(0);
            }
        } while (!isValidNextMove(currentY, currentX, playerPosY, playerPosX));

        playerNextMoveAction(currentY, currentX);
        ++playerCountStep;
    }

    public static boolean isValidNextMove(int currentY, int currentX, int nextY, int nextX) {
        if (nextY >= 0 && nextY < mapHeight && nextX >= 0 && nextX < mapWidth) {
            System.out.println("Player move to [" + (nextX + 1) + ":" + (nextY + 1) + "]  success");
            return true;
        } else {
            playerPosX = currentX;
            playerPosY = currentY;
            System.out.println("Invalid move. Please try again");
            return false;
        }
    }

    public static void playerNextMoveAction(int currentY, int currentX) {
        map[currentY][currentX] = readyCell;
        map[playerPosY][playerPosX] = player;
    }

    public static int randomRange(int min, int max) {
        int diff = max - min;
        int value = random.nextInt(diff + 1);
        return min + value;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if (map[y][x] == emptyCell) return false;
            }
        }
        return true;
    }

    public static boolean isPlayerAlive() {
        return playerHealth > 0;
    }
}
