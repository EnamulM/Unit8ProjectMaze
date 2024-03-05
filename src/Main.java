import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] maze = MazeSolver.getMaze("src/Maze");
        traverseMaze(maze);

    }

    public static String[] traverseMaze(String[][] maze) {
        String move = ".";
        int rows = maze.length;
        int columns = maze[0].length;
        String[] path = new String[rows * columns];
        for (int i = 0; i < rows; i++) {
            for (int r = 0; r < columns; r++) {
                if (maze[i][r].equals(move)) {
                    path[i] = ("(" + i + ", " + r +  ")" + ", ");
                }
            }
        }
        for(int i = 0; i < path.length; i++){
            System.out.print(path[i]);
        }
        return path;
    }

}