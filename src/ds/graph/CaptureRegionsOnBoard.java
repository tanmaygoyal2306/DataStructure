package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/capture-regions-on-board/
 */
public class CaptureRegionsOnBoard {

    public void solve(ArrayList<ArrayList<Character>> a) {
        boolean visited[][] = new boolean[a.size()][a.get(0).size()];
        for (int i = 0; i < a.size(); i++)
        {
            for (int j = 0; j < a.get(i).size(); j++)
            {
                if (visited[i][j])
                    continue;
                if (a.get(i).get(j) == 'X')
                {
                    continue;
                }
                List<List<Integer>> capturedPoints = new ArrayList<>();
                if(capture(a, i, j,visited, capturedPoints))
                {
                    for (List<Integer> point : capturedPoints)
                        a.get(point.get(0)).set(point.get(1), 'X');
                }
            }
        }
    }

    private boolean capture(ArrayList<ArrayList<Character>> a, int i, int j, boolean[][] visited, List<List<Integer>> capturedPoints) {
        if (i >= a.size() || i < 0 || j >= a.get(i).size() || j < 0)
            return false;
        if (visited[i][j])
            return true;

        visited[i][j] = true;
        if (a.get(i).get(j) == 'X')
            return true;

        capturedPoints.add(new ArrayList<>(Arrays.asList(i, j)));
        boolean isFlip = capture(a, i-1, j, visited, capturedPoints) ;
        isFlip = capture(a, i+1, j, visited, capturedPoints) && isFlip;
        isFlip = capture(a, i, j-1, visited, capturedPoints) && isFlip;
        isFlip = capture(a, i, j+1, visited, capturedPoints) && isFlip;

        return isFlip;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList('X', 'X', 'X', 'X')));
        list.add(new ArrayList<>(Arrays.asList('X', 'O', 'O', 'X')));
        list.add(new ArrayList<>(Arrays.asList('X', 'X', 'O', 'X')));
        list.add(new ArrayList<>(Arrays.asList('X', 'O', 'X', 'X')));

        new CaptureRegionsOnBoard().solve(list);

        System.out.println(list);
    }
}
