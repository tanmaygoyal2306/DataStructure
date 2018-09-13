package ds.dp;
/**
 * https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
 */

import java.util.ArrayList;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(new MaxRectangleInBinaryMatrix().calculateMaxArea(new int[]{
                1,2,3,2,2
        }));
    }

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int col  = A.get(0).size();
        int maxArea = Integer.MIN_VALUE;
        int a[] = new int[row];

        for (int i = 0; i < col; i++)
        {
            for (int j = 0; j < row; j++)
            {
                if (A.get(j).get(i) == 0)
                    a[j] = 0;
                else
                    a[j] = a[j]+1;
            }
            maxArea = Math.max(maxArea, calculateMaxArea(a));
        }

        return maxArea;
    }

    private int calculateMaxArea(int[] a)
    {
        Stack<Integer> s = new Stack<>();
        int area =0, maxArea = 0, i =0;
        for (i = 0; i < a.length;)
        {
            if (s.isEmpty() || a[i] >= a[s.peek()])
                s.push(i++);
            else
            {
                int top = s.pop();
                area = s.isEmpty() ? a[top]*i : a[top]*(i-s.peek()-1);
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!s.isEmpty())
        {
            int top = s.pop();
            area = s.isEmpty() ? a[top]*i : a[top]*(i-s.peek()-1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
