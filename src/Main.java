import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] maze = MazeSolver.getMaze("src/Maze");
        traverseMaze(maze);

    }

    public static ArrayList traverseMaze(String[][] maze) {
        String move = ".";
        String wall = "#";
        int rows = maze.length;
        int columns = maze[0].length;
        ArrayList path = new ArrayList(0);
        for (int i = 0; i < rows; i++) {
            for (int r = 0; r < columns; r++) {
                if (maze[i][r].equals(move)) {
                    path.add(("(" + i + ", " + r +  ")" + ""));
                    if(maze[i][r].equals(wall)){
                        System.out.println("Add Logic");
                    }
                }
            }
        }
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i));
        }
        return path;
    }

}