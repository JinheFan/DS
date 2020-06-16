package recursion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class HorseChess {

    private static int X;
    private static int Y;
    private static boolean[] visited;
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        visited = new boolean[X * Y];
        int[][] chessboard = new int[X][Y];
        traverse(chessboard, 0, 0, 1);
        for (int[] row : chessboard) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void traverse(int[][] chessboard, int row, int col, int step) {
        chessboard[row][col] = step;
        visited[row * X + col] = true;
        List<Point> pointList = next(new Point(row, col));
        sort(pointList);
        while (!pointList.isEmpty()) {
            Point point = pointList.remove(0);
            if (!visited[point.y * X + point.x]) {
                traverse(chessboard, point.y, point.x, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessboard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }

    private static List<Point> next(Point cur) {
        List<Point> res = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y - 1) >= 0) {
            res.add(new Point(p1));
        }
        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y - 2) >= 0) {
            res.add(new Point(p1));
        }
        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y - 2) >= 0) {
            res.add(new Point(p1));
        }
        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y - 1) >= 0) {
            res.add(new Point(p1));
        }
        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y + 1) < Y) {
            res.add(new Point(p1));
        }
        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y + 2) < Y) {
            res.add(new Point(p1));
        }
        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y + 2) < Y) {
            res.add(new Point(p1));
        }
        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y + 1) < Y) {
            res.add(new Point(p1));
        }
        return res;
    }

    public static void sort(List<Point> points) {
        points.sort((p1, p2) -> {
            int count1 = next(p1).size();
            int count2 = next(p2).size();
            if (count1 < count2) {
                return -1;
            } else if (count1 == count2) {
                return 0;
            } else  {
                return 1;
            }
        });
    }
}
