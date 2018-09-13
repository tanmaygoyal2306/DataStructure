package ds.graph;

/**
 * https://www.interviewbit.com/problems/commutable-islands/
 */

import java.util.*;

public class CommutableIslands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        Collections.sort(B, Comparator.comparingInt(o -> o.get(2)));
        int cost = 0;
        Set<ArrayList<Integer>> visitedEdge = new HashSet<>();
        DisjointSet disjointSet = new DisjointSet(A);
        for (ArrayList<Integer> edge : B) {
            int node1 = edge.get(0);
            int node2 = edge.get(1);
            int edgeCost = edge.get(2);
            int set1 = disjointSet.findSet(node1);
            int set2 = disjointSet.findSet(node2);
            if(disjointSet.union(set1, set2)){
                visitedEdge.add(edge);
                cost += edgeCost;
            }
            if (visitedEdge.size() == A - 1) {
                return cost;
            }
        }
        return 0;

    }
}

class DisjointSet {
    private Map<Integer, Node> map = new HashMap<>();

    class Node {
        int data;
        Node parent;
        int rank;
    }

    DisjointSet(int A) {
        for (int i = 1; i <= A; i++) {
            makeSet(i);
        }
    }

    private void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }


    public boolean union(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if (parent1.data == parent2.data) {
            return false;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    public int findSet(int data) {
        return findSet(map.get(data)).data;
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }
}
