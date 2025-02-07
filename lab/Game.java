import java.util.*;
import model.Visualization;
import model.Menu;
import model.MazeGenerator;

public class Game {
    static Scanner scan = new Scanner(System.in);
    public static int difficulty = 7;

    public static int[][] maze = MazeGenerator.generateMaze(difficulty);
    public static int[] currentPosition = MazeGenerator.findStart(maze);
    public static int[] finalPosition = MazeGenerator.findExit(maze);
 


    public static void main(String args[]) {

        //first cycle
        Visualization.printMenu();
        Menu.start();
        Visualization.deleteMaze();
        Visualization.printMaze(maze, currentPosition, finalPosition);
        startGame();
        Visualization.printCongrats();

        //next level
        while (true) {
        Visualization.deleteMaze();
        Menu.nextLevel();
        Visualization.deleteMaze();

        // Генерация нового лабиринта
        maze = MazeGenerator.generateMaze(difficulty);
        currentPosition = MazeGenerator.findStart(maze);
        finalPosition = MazeGenerator.findExit(maze);

        Visualization.printMaze(maze, currentPosition, finalPosition);
        startGame(); // Запускаем игру для нового уровня
        Visualization.printCongrats(); // Поздравляем после прохождения уровня
    }
        
    }



    public static void startGame() {
        while (currentPosition[0] != finalPosition[0] || currentPosition[1] != finalPosition[1]) {
            System.out.println("Enter the move:");
            String step = scan.next().toLowerCase();
            
            if (step.equals("s")) {
                if (currentPosition[0] == maze.length - 1) {
                    System.out.println("You are not able to do that move");
                } else if (maze[currentPosition[0] + 1][currentPosition[1]] == 0 || currentPosition[0] == finalPosition[0] && currentPosition[1] + 1 == finalPosition[1]) {
             
                    currentPosition[0] += 1;
                }
            } else if (step.equals("w")) {
                if (currentPosition[0] == 0) {
                    System.out.println("You are not able to do that move");
                } else if (maze[currentPosition[0] - 1][currentPosition[1]] == 0 || currentPosition[0] == finalPosition[0] && currentPosition[1] + 1 == finalPosition[1]) {
                
                    currentPosition[0] -= 1;
                }
            } else if (step.equals("a")) {
                if (currentPosition[1] == 0) {
                    System.out.println("You are not able to do that move");
                } else if (maze[currentPosition[0]][currentPosition[1] - 1] == 0 || currentPosition[0] == finalPosition[0] && currentPosition[1] + 1 == finalPosition[1]) {
              
                    currentPosition[1] -= 1;
                }
            } else if (step.equals("d")) {
                if (currentPosition[1] == maze[0].length) {
                    System.out.println("You are not able to do that move");
                } else if (maze[currentPosition[0]][currentPosition[1] + 1] == 0 || currentPosition[0] == finalPosition[0] && currentPosition[1] + 1 == finalPosition[1]) {
               
                    currentPosition[1] += 1;
                }
            } else {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
            Visualization.deleteMaze();
            Visualization.printMaze(maze, currentPosition, finalPosition);

        }


    }
}