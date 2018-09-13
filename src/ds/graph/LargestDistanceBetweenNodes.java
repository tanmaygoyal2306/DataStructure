package ds.graph;

/**
 * https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
 */

import java.util.*;

public class LargestDistanceBetweenNodes {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-1, 0, 0, 0, 3, 2, 5));
       System.out.println(new LargestDistanceBetweenNodes().solve(a));
    }
    Map<Integer, List<Integer>> graph ;
    public int solve(ArrayList<Integer> A) {
        if (isSkewTree(A))
            return A.size()-1;
        int root = createGraph(A);
        Result result = new Result();
        result.result = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();
        dfsUtil(root, visited,result);

        return result.result;
    }

    private boolean isSkewTree(ArrayList<Integer> A) {
        boolean isSkewTree = true;
        for (int i = 0; i < A.size(); i++)
        {
            if (A.get(i) != i-1){
                isSkewTree = false;
                break;
            }
        }
        return isSkewTree;
    }

    private int dfsUtil(int vertex, Set<Integer> visited, Result result)
    {
        if (visited.contains(vertex))
            return 0;
        int max = 0;
        int secondMax = 0;
        for (Integer child : graph.get(vertex))
        {
            int height = dfsUtil(child, visited, result);
            if (height >= max)
            {
                secondMax = max;
                max = height;
                continue;
            }
            if (height > secondMax)
            {
                secondMax = height;
            }
        }
        result.result = Math.max(max + secondMax, result.result);
        return max + 1;
    }

    private int createGraph(ArrayList<Integer> a) {
        graph = new HashMap<>();
        int root = -1;
        for (int i = 0; i< a.size(); i++)
        {
            if (a.get(i) == -1){
                root = i;
                continue;
            }
            List<Integer> adjVertices = graph.getOrDefault(a.get(i), new ArrayList<>());
            adjVertices.add(i);
            graph.put(a.get(i), adjVertices);
        }
        for (int i = 0; i < a.size(); i++)
        {
            if (!graph.containsKey(i))
                graph.put(i, new ArrayList<>());
        }
        return root;
    }
}

class Result{
    int result;
}