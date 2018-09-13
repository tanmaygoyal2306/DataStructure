package ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class VerticalOrderTraverser {

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        TreeMap<Integer, ArrayList<DummyNode>> map = new TreeMap<>();
        verticalOrderTraversalUtil(A , map , 0, 0);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int level : map.keySet())
        {
            ArrayList<DummyNode> innerList = map.get(level);
            Collections.sort(innerList, (o1, o2) -> {
                if(o1.horizontalLevel > o2.horizontalLevel)
                    return 1;
                if(o1.horizontalLevel < o2.horizontalLevel)
                    return -1;
                return 0;
            });
            ArrayList<Integer> innerListInt = new ArrayList<>();
            for(DummyNode d : innerList)
                innerListInt.add(d.data);
            list.add(innerListInt);
        }
        return list;
    }
    private void verticalOrderTraversalUtil(TreeNode root, TreeMap<Integer, ArrayList<DummyNode>> map, int level, int horizontalLevel)
    {
        if(root == null)
            return;
        ArrayList<DummyNode> list = map.get(level);
        if(list == null)
            list = new ArrayList<>();
        list.add(new DummyNode(root.val, horizontalLevel));
        map.put(level, list);
        verticalOrderTraversalUtil(root.left, map, level-1, horizontalLevel + 1);
        verticalOrderTraversalUtil(root.right, map, level+1, horizontalLevel + 1);
    }
    class DummyNode{
        int horizontalLevel;
        int data;
        public DummyNode(int data, int level) {
            this.data =  data;
            this.horizontalLevel = level;
        }
    }
}
