package ds.dp;
/**
 * https://www.interviewbit.com/problems/longest-arithmetic-progression/
 */

import java.util.Arrays;
import java.util.List;

public class LongestAP {
    public static void main(String[] args) {
        System.out.println(new LongestAP().solve(Arrays.asList(3)));
    }

    public int solve(final List<Integer> A) {
        if (A.size() < 2)
            return A.size();
        int[][] diff = new int[A.size()][A.size()];
        int maxLen = 2, len = 2;
        for (int i = 0; i < A.size();i++)
        {
            for (int j = i+1; j < A.size();j++)
            {
                diff[i][j] = A.get(j) - A.get(i);
            }
        }
        for (int i = 0; i < A.size();i++)
        {
            for (int j = i+1; j < A.size();j++)
            {
                len = 2;
                for (int k = j+1; k < A.size();k++)
                {
                    if (A.get(k) - A.get(j) == diff[i][j]*(len-1))
                        len++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }
}
