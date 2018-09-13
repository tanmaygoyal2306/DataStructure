package ds.graph;

/**
 * https://www.interviewbit.com/problems/knight-on-chess-board/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}


public class KnightMovementBFS {

    private int N;
    private int M;

    private int knight(int A, int B, int C, int D, int E, int F) {
        N = A;
        M = B;
        HashSet<Point> visited = new HashSet<Point>();
        Point source = new Point(C, D);
        Point destination = new Point(E, F);
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(source);
        queue.add(null);
        int level = 0;
        while (!queue.isEmpty()) {
            Point point = queue.removeFirst();
            if (point == null) {
                if (queue.size() > 0) {
                    queue.add(null);
                    level++;
                }
                continue;
            }
            visited.add(point);
            if (point.equals(destination))
                return level;
            List<Point> nextPossiblePoints = getNextPossiblePoints(point, visited,queue);
            queue.addAll(nextPossiblePoints);
        }
        return -1;
    }

    private List<Point> getNextPossiblePoints(Point point, HashSet<Point> visited, LinkedList<Point> queue) {
        List<Point> list = new ArrayList<Point>();
        int x = point.x, y = point.y;
        list.add(new Point(x + 1, y + 2));
        list.add(new Point(x + 1, y - 2));
        list.add(new Point(x - 1, y + 2));
        list.add(new Point(x - 1, y - 2));
        list.add(new Point(x + 2, y + 1));
        list.add(new Point(x + 2, y - 1));
        list.add(new Point(x - 2, y + 1));
        list.add(new Point(x - 2, y - 1));

        return list.stream().filter(p -> validate(p, visited, queue)).collect(Collectors.toList());
    }

    private boolean validate(Point point, HashSet<Point> visited, LinkedList<Point> queue) {
        if (point.x > N || point.y > M || point.x < 1 || point.y < 1)
            return false;
        if (visited.contains(point))
            return false;
        if (queue.contains(point))
            return false;
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new KnightMovementBFS().knight(3, 3, 1, 1, 3, 3));
    }
}

