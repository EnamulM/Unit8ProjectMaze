import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] maze = MazeSolver.getMaze("src/Maze");
        for (String[] row : maze) {
            for (String column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}