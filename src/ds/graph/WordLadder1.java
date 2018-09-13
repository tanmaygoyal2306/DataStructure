package ds.graph;

/**
 * https://www.interviewbit.com/problems/word-ladder-i/
 */

import java.util.*;

public class WordLadder1 {

    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(new WordLadder1().ladderLength("hit", "cog", dict));
    }

    private Map<String , List<String>> graph;

    private int ladderLength(String start, String end, ArrayList<String> dictV) {
        List<String> allVertices = new ArrayList<>(dictV);
        allVertices.add(start);
        allVertices.add(end);

        createGraph(allVertices);

        return bfs(start, end);

    }

    private int bfs(String start, String end) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        queue.add(null);
        int level = 1;
        while (!queue.isEmpty())
        {
            String vertex = queue.removeFirst();
            if (vertex == null)
            {
                if (queue.size() > 0)
                {
                    queue.add(null);
                    level++;
                }
                continue;
            }
            if (visited.contains(vertex))
                continue;
            visited.add(vertex);
            //System.out.print(vertex+ " ");
            if (end.equals(vertex))
                return level;
            List<String> adjVertices = graph.get(vertex);
            queue.addAll(adjVertices);
        }
        return 0;
    }

    private void createGraph(List<String> allVertices) {
        graph = new HashMap<>();
        for (int i = 0; i < allVertices.size(); i++)
        {
            String first = allVertices.get(i);
            for (int j = 0; j < allVertices.size(); j++)
            {
                if (i==j)
                    continue;
                if (isDiffByOne(first, allVertices.get(j)))
                {
                    List<String> adjVertices = graph.getOrDefault(first, new ArrayList<>());
                    adjVertices.add(allVertices.get(j));
                    graph.put(first, adjVertices);
                }
            }
        }
        for (String vertex : allVertices)
        {
            if (!graph.containsKey(vertex))
            {
                graph.put(vertex, new ArrayList<>());
            }
        }
    }

    private boolean isDiffByOne(String first, String second)
    {
        int diff = 0;
        for (int i = 0; i < first.length(); i++)
        {
            if (first.charAt(i) != second.charAt(i))
                diff++;
            if (diff > 1)
                return false;
        }

        return diff != 0;
    }
}
