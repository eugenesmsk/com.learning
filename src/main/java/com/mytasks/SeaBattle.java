package com.mytasks;

public class SeaBattle {
    public static void main(String[] args) {
        int fieldSize = (int) (1 + Math.random() * 15);
        int[][] field = new int[fieldSize][fieldSize];

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        

    }
}
