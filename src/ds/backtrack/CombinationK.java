package ds.backtrack;
/**
 * https://www.interviewbit.com/problems/combinations/
 */

import java.util.ArrayList;

public class CombinationK {

	public static void main(String[] args) {
		new CombinationK().combine(4, 4)
				.forEach(e -> {
				    e.forEach(e1 -> System.out.print(e1 + " "));
				    System.out.println();
				});
	
		
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> outList = new ArrayList<>();
		int[] count = new int[n];
		for (int j = 0; j < count.length; j++) {
			count[j] = 1;
		}
		ArrayList<Integer> output = new ArrayList<>();
		combineRec(0, k, 1, count, outList, output);
		return outList;
	}
	private void combineRec(int pos, int k, int elem, int[] count, ArrayList<ArrayList<Integer>> outList, ArrayList<Integer> output) {
		if(output.size() == k)
			outList.add(new ArrayList<>(output));
		for (int i = pos; i < count.length; i++) {
			if(count[i] == 0)
				continue;
			output.add(elem++);
			count[i]--;
			combineRec(i, k, elem, count, outList, output);
			count[i]++;
			output.remove(output.size()-1);
		}
	}

}
