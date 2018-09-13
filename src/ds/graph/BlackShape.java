package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/black-shapes/
 */

public class BlackShape {
    public int black(ArrayList<String> A) {
        int count = 0;
        boolean visited[][] = new boolean[A.size()][A.get(0).length()];
        for (int i = 0; i < A.size(); i++)
        {
            String data = A.get(i);
            for (int j = 0; j < data.length(); j++)
            {
                if (isWhiteCell(data, j) || visited[i][j])
                    continue;
                markVisited(visited, A, i, j);
                count++;
            }
        }
        return count;
    }

    private boolean isWhiteCell(String data, int j) {
        return data.charAt(j) == 'O';
    }

    private void markVisited(boolean[][] visited, ArrayList<String> a, int i, int j) {
        if(i < 0 || i >= a.size() || j < 0 || j >= a.get(0).length() || visited[i][j])
            return;
        if (isWhiteCell(a.get(i), j))
            return;

        visited[i][j] = true;
        markVisited(visited, a, i-1, j);
        markVisited(visited, a, i+1, j);
        markVisited(visited, a, i, j-1);
        markVisited(visited, a, i, j+1);
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>(Arrays.asList("XXX", "XXX", "XXX"));
        System.out.println(new BlackShape().black(a));
    }
}
