import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class MazeSolver {
    private int rows;
    private int columns;
    private String[][] maze;
    public MazeSolver(String[][] maze){
        this.maze = maze;
        this.columns = maze[0].length;
        this.rows = maze.length;

    }

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;
    }
    public ArrayList<String> traverseMaze() {
        String move = ".";
        String wall = "#";
        int rows = maze.length;
        int columns = maze[0].length;
        ArrayList path = new ArrayList(0);
        for (int i = 0; i < rows; i++) {
            for (int r = 0; r < columns; r++) {
                if (maze[i][r].equals(move)) {
                    path.add(("(" + i + ", " + r +  ")" + ""));

                }
            }
        }
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i));
        }
        return path;
    }
    public boolean solveMaze(int x, int y, ArrayList<String> path){
        if (x == rows - 1 && y == columns - 1) {
            path.add("(" + x + ", " + y + ")");
            return true;
        }
        maze[x][y] = "X";
        //Move East
        if (y + 1 < columns && maze[x][y + 1].equals(".")) {
            path.add("(" + x + ", " + y + ")");
            if (solveMaze(x, y + 1, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        return false;
    }
}

