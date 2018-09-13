package ds.array;

public class BinarySearchCountOccurance {

	public static void main(String[] args) {
		
		int a[] = new int[]{
				5, 7, 7, 8, 8, 10	
		};
		int count = binarySearchCount(a, 8, false) - binarySearchCount(a, 8, true) + 1;
		System.out.println(count);
	}

	public static int binarySearchCount(int a[], int x, boolean searchFirst)
	{
		int result = -1;
		int low = 0, high = a.length-1;
		
		while(low <= high)
		{
			int mid= (high + low)/2;
			if(a[mid] == x)
			{
				result = mid;
				if(searchFirst)
					high = mid-1;
				else
					low = mid+1;
			}
			else if(a[mid] > x)
				high = mid-1;
			else
				low = mid+1;
		}
		
		return result;
	}
}
