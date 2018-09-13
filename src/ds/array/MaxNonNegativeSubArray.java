package ds.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, -1, 2, 2));

        new MaxNonNegativeSubArray().maxSet(a).forEach(System.out::println);
    }

    private ArrayList<Integer> maxSet(ArrayList<Integer> a) {
        if(a == null || a.size() == 0)
            return a;
        long sum[] = new long[a.size()];
        int index[] = new int[a.size()];
        long maxSum = -1, currentSum = 0;
        int startIndex = a.get(0) >= 0 ? 0 : -1;
        for (int i = 0; i < a.size(); )
        {
            while (i < a.size() && a.get(i) >= 0)
            {
                currentSum += a.get(i);
                sum[i] = currentSum;
                index[i] = startIndex;
                i++;
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
            while (i < a.size() && a.get(i) < 0)
            {
                sum[i] = -1;
                index[i] = -1;
                i++;
            }
            if (i != a.size())
            {
                startIndex = i;
                currentSum = 0;
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        if (startIndex == -1)
            return output;
        int currSegLength, maxSegLength = -1;
        int endIndex = 0;
        for (int i = 0; i < sum.length ; i++)
        {
            if (sum[i] != maxSum)
                continue;
            currSegLength = i - index[i];
            if (currSegLength > maxSegLength)
            {
                maxSegLength = currSegLength;
                endIndex = i;
            }
        }
        for (int i = index[endIndex]; i <= endIndex ;i++)
            output.add(a.get(i));

        return output;
    }
}
