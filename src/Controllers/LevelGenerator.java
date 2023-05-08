package Controllers;

import java.util.Stack;

public class LevelGenerator {
    public static int[][] generateLevel(int size) {
        int sizeModifier = size % 2 + 1;

        int[][] level = new int[size][size];
        int x, y;

        do {
            x = (int) (Math.random() * size);
        } while (x % 2 != 0);

        do {
            y = (int) (Math.random() * size);
        } while (y % 2 != 0);

        Stack<int[]> movesStack = new Stack<>();
        movesStack.push(new int[]{x, y});

        while (movesStack.size() > 0) {
            int[] possibleMoves = new int[4];
            int possibleMovesCounter = 0;
            if (x - 2 >= 0 && level[y][x - 2] == 0) {
                possibleMoves[possibleMovesCounter++] = 0;
            }
            if (x + 2 < size && level[y][x + 2] == 0) {
                possibleMoves[possibleMovesCounter++] = 1;
            }
            if (y - 2 >= 0 && level[y - 2][x] == 0) {
                possibleMoves[possibleMovesCounter++] = 2;
            }

            if (y + 2 < size && level[y + 2][x] == 0) {
                possibleMoves[possibleMovesCounter++] = 3;
            }
            if (possibleMovesCounter > 0) {
                switch (possibleMoves[(int) (Math.random() * possibleMovesCounter)]) {
                    case 0 -> {
                        level[y][--x] = 1;
                        level[y][--x] = 1;
                        movesStack.push(new int[]{x, y});
                    }
                    case 1 -> {
                        level[y][++x] = 1;
                        level[y][++x] = 1;
                        movesStack.push(new int[]{x, y});
                    }
                    case 2 -> {
                        level[--y][x] = 1;
                        level[--y][x] = 1;
                        movesStack.push(new int[]{x, y});
                    }
                    case 3 -> {
                        level[++y][x] = 1;
                        level[++y][x] = 1;
                        movesStack.push(new int[]{x, y});
                    }
                }
            } else {
                int[] lastMove = movesStack.pop();
                x = lastMove[0];
                y = lastMove[1];
            }
        }
        int[][] finalLevel = new int[size + sizeModifier][size + sizeModifier];
        for (int i = 0; i < finalLevel.length; i++) {
            for (int j = 0; j < finalLevel[i].length; j++) {
                if (i == 0 || j == 0 || i == finalLevel.length - 1 || j == finalLevel.length - 1) {
                    finalLevel[i][j] = 0;
                } else {
                    finalLevel[i][j] = level[i - 1][j - 1];
                }
            }
        }
        int[][] finalFinalLevel = new int[finalLevel.length][finalLevel.length];
        for (int i = 0; i < finalLevel.length; i++) {
            for (int j = 0; j < finalLevel[i].length; j++) {
                if (finalLevel[i][j] == 0) {
                    int sum = 0;

                    if (i - 1 >= 0 && finalLevel[i - 1][j] == 0) {
                        sum += 1;
                    }
                    if (i + 1 < finalLevel.length && finalLevel[i + 1][j] == 0) {
                        sum += 2;
                    }
                    if (j - 1 >= 0 && finalLevel[i][j - 1] == 0) {
                        sum += 4;
                    }
                    if (j + 1 < finalLevel.length && finalLevel[i][j + 1] == 0) {
                        sum += 8;
                    }
                    finalFinalLevel[i][j] = sum;
                } else {
                    finalFinalLevel[i][j] = 99;
                }
            }
        }

        return finalFinalLevel;
    }
}
