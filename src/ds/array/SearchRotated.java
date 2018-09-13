package ds.array;

import java.util.Arrays;
import java.util.List;

public class SearchRotated {

	public static void main(String[] args) {
		Integer a[] = new Integer[]{
				4, 5, 6, 7, 0, 1, 2
		};
		System.out.println(new SearchRotated().search(Arrays.asList(a), 2));
	}
	
	public int search(final List<Integer> a, int b) {
		return search(a, b, 0, a.size()-1);
	}
	public int search(final List<Integer> a , int x, int low, int high)
	{
		if(low > high)
			return -1;
		int mid = (low+high)/2;
		if(a.get(mid) == x)
			return mid;
		if(a.get(mid) > x && a.get(high) < x)
			return search(a, x, low, mid-1);
		if(a.get(mid) < x && a.get(low) > x)
			return search(a, x, mid+1, high);
		else
		{
			int result = search(a, x, low, mid-1);
			if(result != -1)
				return result;
			return search(a, x, mid+1, high);
		}
		
	}

}
