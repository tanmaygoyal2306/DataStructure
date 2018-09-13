package ds.dp;

/**
 * https://www.interviewbit.com/problems/interleaving-strings/
 */

public class InterleavingString
{
    public static void main(String[] args) {
        String A = "USfMSU";
        String B = "5YgZ9N5mR6ppfggzbzh7HTox85MwFtaIQDHfzJW8vc2G";
        String C = "5YgUSZf9NM5SmR6Uppfggzbzh7HTox84MwFtaIQDHfzJW8vc2G";
        System.out.println(new InterleavingString().isInterleave(A,B,C));
    }
    public int isInterleave(String A, String B, String C) {
        return isInterleaveUtil(A,B,C,0,0,0) ? 1  : 0;
    }

    private boolean isInterleaveUtil(String A, String B, String C, int iA, int iB, int iC) {
        if (iC == C.length() && iC == iA + iB)
            return true;

        if (iA < A.length() && C.charAt(iC) != A.charAt(iA) && iB < B.length() && C.charAt(iC) != B.charAt(iB))
            return false;

        if (iA < A.length()&& C.charAt(iC) == A.charAt(iA) && iB < B.length() && C.charAt(iC) == B.charAt(iB))
            return (iA < A.length() && isInterleaveUtil(A, B, C, iA+1, iB, iC+1)) ||
                    (iB < B.length()) && isInterleaveUtil(A, B, C, iA, iB+1, iC+1) ;

        if (iA < A.length() && C.charAt(iC) == A.charAt(iA))
            return isInterleaveUtil(A, B, C, iA+1, iB, iC+1);

        if (iB < B.length() && C.charAt(iC) == B.charAt(iB))
            return isInterleaveUtil(A, B, C, iA, iB+1, iC+1);

        return false;

    }
}
