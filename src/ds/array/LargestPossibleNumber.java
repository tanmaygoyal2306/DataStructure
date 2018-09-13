package ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestPossibleNumber {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(30);
		a.add(34);
		a.add(5);
		a.add(9);
		
		largestNumber(a);
			
	}
	public static String largestNumber(final List<Integer> a) {
		String s[] = new String[a.size()];
		int i = 0;
		for(int data : a)
			s[i++] = data +"";
		Arrays.sort(s, (o1, o2) -> (o1+o2).compareTo(o2+o1));
		String out = "";
		for(String st : s)
			out = st + out;
		if(out.startsWith("0"))
			return "0";
		return out;
	}
}
