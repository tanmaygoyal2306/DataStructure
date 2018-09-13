package ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {

    public static void main(String[] args) {
        new WaveArray().wave(new ArrayList(Arrays.asList(5, 4, 3, 2, 1))).forEach(System.out::println);
    }

    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for (int i = 1; i < a.size(); i += 2) {
            int tmp = a.get(i - 1);
            a.set(i - 1, a.get(i));
            a.set(i, tmp);
        }
        return a;
    }
}
