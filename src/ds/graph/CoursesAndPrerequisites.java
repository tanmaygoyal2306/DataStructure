package ds.graph;

/**
 * https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
 */

import java.util.*;
import static java.util.Arrays.asList;

public class CoursesAndPrerequisites {
    public static void main(String[] args) {
        ArrayList B= new ArrayList(asList(1));
        ArrayList C= new ArrayList(asList(2));

        System.out.println(new CoursesAndPrerequisites().solve(3, B, C));
    }

    private Map<Integer, List<Integer>> graph;
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        graph = createGraph(A, B, C);
        return hasCycle(graph) ? 0 : 1;
    }
    public boolean hasCycle(Map<Integer,List<Integer>> g)
    {
        Set<Integer> whiteSet = new HashSet<>(g.keySet());
        Set<Integer> graySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();
        for (Integer vertex : graph.keySet())
        {
            if (!blackSet.contains(vertex))
            {
                if(hasCycleUtil(vertex, whiteSet, graySet, blackSet))
                    return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(Integer vertex, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet) {
            if (graySet.contains(vertex))
                return true;
            moveVertex(vertex, whiteSet, graySet);
            for (Integer adjVertex : graph.get(vertex))
            {
                if (blackSet.contains(adjVertex))
                    continue;

                if (hasCycleUtil(adjVertex, whiteSet, graySet, blackSet))
                    return true;
            }
            moveVertex(vertex, graySet, blackSet);
            return false;
    }

    private void moveVertex(Integer vertex, Set<Integer> fromSet, Set<Integer> toSet) {
        fromSet.remove(vertex);
        toSet.add(vertex);
    }

    private Map<Integer,List<Integer>> createGraph(int a, ArrayList<Integer> b, ArrayList<Integer> c) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < b.size(); i++)
        {
            List<Integer> adjacentVertices = graph.get(b.get(i));
            if (adjacentVertices == null)
                adjacentVertices = new ArrayList<>();
            adjacentVertices.add(c.get(i));
            graph.put(b.get(i), adjacentVertices);
        }
        for (int i = 1; i <=a ; i++ )
        {
            if (!graph.containsKey(i))
                graph.put(i, new ArrayList<>());
        }
        return graph;
    }
}
