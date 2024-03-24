import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] maze = MazeSolver.getMaze("src/Maze");
        MazeSolver mazeSolver = new MazeSolver(maze);
        ArrayList<String> path = mazeSolver.traverseMaze();
        if (path != null) {
            System.out.println("Solution Path: ");
            for (String coordinate : path) {
                System.out.print(coordinate + " --> ");
            }
            System.out.println("Done!");
            }
        else{
            System.out.print("Error! No solution found");
        }
    }
}