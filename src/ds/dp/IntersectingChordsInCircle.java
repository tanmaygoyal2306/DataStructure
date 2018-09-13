package ds.dp;

/**
 * https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
 */

public class IntersectingChordsInCircle {
    public static void main(String[] args) {
        System.out.println(new IntersectingChordsInCircle().chordCnt(1000));
    }

    public int chordCnt(int A)
    {
        if (A <= 1 )
            return A;
        long T[] = new long[A+1];
        T[0] = 1;
        T[1] = 1;
        T[2] = 2;
        for (int i = 3; i <= A; i++) {
            long sum = 0;
            for (int k = 0; k < i; k++) {
                int j = k+1;
                sum += T[i-j]*T[j-1];
                sum = sum%(1000000007);
            }
            T[i] = sum%(1000000007);
        }
        return (int) T[A]%(1000000007);
    }
}
