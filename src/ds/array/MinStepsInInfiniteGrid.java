package ds.array;

import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
  https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */


public class MinStepsInInfiniteGrid {

    private int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int steps = 0;
        for(int i = 1; i < X.size(); i++)
        {
            int fromX = X.get(i-1);
            int toX = X.get(i);
            int fromY = Y.get(i-1);
            int toY = Y.get(i);
            steps += Math.max(Math.abs(toX-fromX), Math.abs(toY-fromY));
        }
        return steps;
    }

    public static void main(String[] args) {
        ArrayList<Integer> X = new ArrayList<>(asList(0,1,1));
        ArrayList<Integer> Y = new ArrayList<>(asList(0,1,2));
        System.out.println(new MinStepsInInfiniteGrid().coverPoints(X, Y));
    }
}
