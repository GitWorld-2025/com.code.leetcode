package com.TopicSolutions;

public class Matrix {
    public static void main(String... args) {
        BattleShipMatrix();
    }

    static void BattleShipMatrix() {
        String[][] board = {{"X", ".", ".", "X"}, {".", ".", ".", "X"}, {".", ".", ".", "X"}};

        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if((i > 0 && board[i-1][j].equalsIgnoreCase("X"))
                    || (j > 0 && board[i][j-1].equalsIgnoreCase("X"))
                )continue;
                else if (board[i][j].equalsIgnoreCase("X"))count++;
            }
        }
        System.out.println("Number of BattleSHips : " + count);
    }
}
