package ds.array;

import java.util.ArrayList;

public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> a, int b) {
        int low = 0, high = a.size() - 1;
        int idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (mid == 0) {
                idx = a.get(mid) > b ? 0 : 1;
                break;
            } else if (mid == a.size() - 1) {
                idx = a.get(a.size() - 1) > b ? a.size() - 1 : a.size();
                break;
            } else if (a.get(mid) > b && a.get(mid - 1) < b)
                return mid;
            else if (a.get(mid) < b && a.get(mid + 1) > b)
                return mid + 1;
            else if (a.get(mid) > b)
                high = mid - 1;
            else if (a.get(mid) < b)
                low = mid + 1;
        }
        return idx;
    }
}
