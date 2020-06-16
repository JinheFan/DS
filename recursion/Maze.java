package recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] maze = new int[8][7];
        for(int i = 0; i < maze[0].length; i++) {
            maze[0][i] = 1;
            maze[maze.length - 1][i] = 1;
        }
        for (int i = 0; i < maze.length - 1; i++) {
            maze[i][0] = 1;
            maze[i][maze[0].length - 1] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;

        getWay(maze, 1, 1);

        for(int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean getWay(int[][] maze, int i, int j) {
        if(maze[6][5] == 2) {
            return true;
        } else {
            if(maze[i][j] == 0) {   // 0 : 没走过
                maze[i][j] = 2;     // 2 : 已经走过
                if (getWay(maze, i + 1, j)) {
                    return true;
                } else if (getWay(maze, i, j + 1)) {
                    return true;
                } else if (getWay(maze, i - 1, j)) {
                    return true;
                } else if (getWay(maze, i, j - 1)) {
                    return true;
                } else {
                    maze[i][j] = 3;     // 3 : 走不通
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
