package Controllers;

import java.util.Arrays;
import java.util.Stack;

public class LevelGenerator {
    public static int[][] generateLevel(int size) {
        int[][] level;
        if (size % 2 == 0) {
            level = new int[size + 1][size + 1];
        } else {
            level = new int[size][size];
        }
        int x, y;


        do {
            x = (int) (Math.random() * size);
        } while (x % 2 == 0);

        do {
            y = (int) (Math.random() * size);
        } while (y % 2 == 0);

        System.out.println("x:" + x);
        System.out.println("y:" + y);
        Stack<int[]> movesStack = new Stack<>();
        movesStack.push(new int[]{x, y});

        while (movesStack.size() > 0) {
            int[] possibleMoves = new int[4];
            int possibleMovesCounter = 0;
            if (x - 2 > 0 && level[y][x - 2] == 0) {
                possibleMoves[possibleMovesCounter++] = 0;
            }
            if (x + 2 < size && level[y][x + 2] == 0) {
                possibleMoves[possibleMovesCounter++] = 1;
            }
            if (y - 2 > 0 && level[y - 2][x] == 0) {
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

        //nieparzyste spoko
        for (int value = 1; value < level.length / 2; value += 4) {
            for (int i = 0; i < level.length; i++) {
                for (int j = 0; j < level[i].length; j++) {
                    if (
                            (i == value && j > value - 1 && j < level[i].length - value) ||
                                    (j == value && i > value - 1 && i < level.length - value) ||
                                    (i == level.length - (value + 1) && j > value - 1 && j < level[i].length - value) ||
                                    (j == level[i].length - (value + 1) && i > value - 1 && i < level.length - value)
                    ) {
                        level[i][j] = 1;
                    }
                }
            }
        }

        int[][] finalLevel = new int[level.length][level.length];
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level[i][j] == 0) {
                    int sum = 0;

                    if (i - 1 >= 0 && level[i - 1][j] == 0) {
                        sum += 1;
                    }
                    if (i + 1 < level.length && level[i + 1][j] == 0) {
                        sum += 2;
                    }
                    if (j - 1 >= 0 && level[i][j - 1] == 0) {
                        sum += 4;
                    }
                    if (j + 1 < level.length && level[i][j + 1] == 0) {
                        sum += 8;
                    }
                    finalLevel[i][j] = sum;
                } else {
                    finalLevel[i][j] = 99;
                }
            }
        }

        return finalLevel;
    }
}
