package ds.dp;

import java.util.ArrayList;
import java.util.Collections;

public class MinSumPathTriangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(2);
        res.add(new ArrayList<Integer>(a.get(0)));

        for (int i = 1; i < a.size(); i++)
        {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            int col = a.get(i).size() - 1;
            for (int j = 0; j <= col ; j++)
            {
                int leftParent = j == 0 ? 0 : j-1;
                int rightParent = j == col ? col - 1 : j;
                int sum = a.get(i).get(j) + Math.min(res.get(0).get(leftParent), res.get(0).get(rightParent));
                tmp.add(sum);
            }
            res.add(tmp);
            //if(i>1)
            res.remove(0);
        }

        return Collections.min(res.get(res.size()-1));
    }
}
