package ds.dp;
/**
 * https://www.interviewbit.com/problems/unique-paths-in-a-grid/
 */

import java.util.ArrayList;

public class UniquePathsInGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        if (A.get(0).get(0) == 1)
            return 0;
        int res[][] = new int[A.size()][A.get(0).size()];
        int ways = 1;
        for (int i = 0; i< A.get(0).size(); i++)
        {
            if(A.get(0).get(i) == 0)
                res[0][i] = ways;
            else {
                ways = 0;
                res[0][i] = ways;
            }
        }
        ways = 1;
        for (int i = 0; i< A.size(); i++)
        {
            if(A.get(i).get(0) == 0)
                res[i][0] = ways;
            else {
                ways = 0;
                res[i][0] = ways;
            }
        }
        for (int i = 1; i < A.size(); i++)
        {
            for (int j = 1 ; j < A.get(i).size(); j++)
            {
                if (A.get(i).get(j) == 0)
                {
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }

        return res[A.size() - 1][A.get(0).size() - 1];
    }
}
