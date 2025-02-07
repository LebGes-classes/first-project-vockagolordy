package model;

public class Visualization {

    public static void printMaze(int[][] maze, int[] currentPosition, int[] finalPosition) {
        String rectangle = "\u2588";
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length; ++j) {
                if (i == currentPosition[0] && j == currentPosition[1]) {
                    System.out.print("Я ");
                } else if (maze[i][j] == 1) {
                    System.out.print(rectangle + " ");
                } else if (i == finalPosition[0] && j == finalPosition[1]) {
                    System.out.print("#" + " ");
                }else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void deleteMaze() {
        try {
            Thread.sleep(1000); // Задержка 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public static void printMenu() {
        System.out.println("Menu\n1 - Start the game\n2 - Rules\n3 - Exit\n");

    }

    public static void printCongrats() {
        System.out.println("Congratulations! You finished a level!");
        System.out.println();
    }
}
