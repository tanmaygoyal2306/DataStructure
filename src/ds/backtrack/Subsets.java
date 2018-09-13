package ds.backtrack;
/**
 * https://www.interviewbit.com/problems/subset/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Subsets {

	public static void main(String[] args) {
		new Subsets().subsets(new ArrayList<>(Arrays.asList(1, 2, 3)))
				.forEach(e -> { e.forEach(e1 -> System.out.print(e1 + " "));
				    System.out.println();
				});
	}
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> outputList = new ArrayList<>();
		TreeMap<Integer, Integer> elemToCountMap = new TreeMap<>();
		for (int elem : a) {
			Integer count = elemToCountMap.get(elem);
			if(count == null)
				count = 0;
			elemToCountMap.put(elem, count+1);
		}
		int[] elem = new int[elemToCountMap.size()];
		int[] count = new int[elemToCountMap.size()];
		int i = 0;
		for(Integer key : elemToCountMap.keySet())
		{
			elem[i] = key;
			count[i] = elemToCountMap.get(key);
			i++;
		}
		ArrayList<Integer> output = new ArrayList<>();
		subsetsRec(0, elem, count, outputList, output);
		return outputList;
	}

	private void subsetsRec(int pos, int[] elem, int[] count, ArrayList<ArrayList<Integer>> outputList, ArrayList<Integer> output) {
		outputList.add(new ArrayList<>(output));
		for (int i = pos; i < count.length; i++) {
			if(count[i] == 0)
				continue;
			output.add(elem[i]);
			count[i]--;
			subsetsRec(i, elem, count, outputList, output);
			count[i]++;
			output.remove(output.size()-1);
		}
	}

}
