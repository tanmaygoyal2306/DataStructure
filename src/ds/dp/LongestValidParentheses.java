package ds.dp;
/**
 * https://www.interviewbit.com/problems/longest-valid-parentheses/
 */

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(())"));
    }

    public int longestValidParentheses(String A) {
        int len  = 0, maxLength = 0;

        int[] valid = new int[A.length()];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < A.length(); i++)
        {
            if (A.charAt(i) == '(')
                s.push(i);
            else
            {
                if (!s.isEmpty()){
                    int j = s.pop();
                    valid[i] = 1;
                    valid[j] = 1;
                }
            }
        }
        for (int i = 0; i < A.length(); i++) {
            if (valid[i] == 1)
                len++;
            else
            {
                maxLength = Math.max(maxLength,len);
                len = 0;
            }

        }

        return Math.max(maxLength,len) ;
    }

}
