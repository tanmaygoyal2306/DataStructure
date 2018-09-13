package ds.dp;
/**
 * https://www.interviewbit.com/problems/longest-increasing-subsequence/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        List a = new ArrayList(Arrays.asList(0,1));
        System.out.println(new LongestIncreasingSubsequence().lis(a));


    }

    public int lis(final List<Integer> A) {
        int T[] = new int[A.size()];
        for (int i = 0; i < T.length; i++)
            T[i] = 1;
        int max= 1;
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    T[i] = Math.max(T[j] + 1, T[i]);
                    max = Math.max(T[i], max);
                }
            }
        }
        return max;
    }
}
