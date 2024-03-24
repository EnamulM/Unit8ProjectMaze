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
        ArrayList<String> solution = new ArrayList<>();
        if (solveMaze(0, 0, solution)){
            return solution;
        }
        return null;
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
        // Move North
        if (x - 1 >= 0 && maze[x - 1][y].equals(".")) {
            path.add("(" + x + ", " + y + ")");
            if (solveMaze(x - 1, y, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        //Move West
        if (y - 1 >= 0 && maze[x][y - 1].equals(".")) {
            path.add("(" + x + ", " + y + ")");
            if (solveMaze(x, y - 1, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        //Move South
        if (x + 1 < rows && maze[x + 1][y].equals(".")) {
            path.add("(" + x + ", " + y + ")");
            if (solveMaze(x + 1, y, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        return false;
    }
}

