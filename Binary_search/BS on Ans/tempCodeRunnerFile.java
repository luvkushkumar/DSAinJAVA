
// Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1.
// Example 1
// Input: N = 3, M = 27
// Output: 3
// Explanation: The cube root of 27 is equal to 3.

// Example 2
// Input: N = 4, M = 69
// Output:-1
// Explanation: The 4th root of 69 does not exist. So, the answer is -1.
public class NthRootofNum {

    public static int find(int val, int N, int M) {
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= val;
            if (ans > M)
                return -1;
        }
        return (ans == M) ? M : -1;
    }

    public static int NthRoot(int N, int M) {
        for (int i = 1; i <= M; i++) {
            if (find(i, N, M) == M)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3,m=27;
        System.out.println(NthRoot(n,m));
    }
    
}
