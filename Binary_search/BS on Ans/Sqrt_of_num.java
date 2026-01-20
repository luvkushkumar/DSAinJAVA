// Given a positive integer n. Find and return its square root. If n is not a perfect square, then return the floor value of sqrt(n).
// Example 1
// Input: n = 36
// Output: 6
// Explanation: 6 is the square root of 36.
// Example 2
// Input: n = 28
// Output: 5
// Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5.

import java.util.Scanner;
//naive solution
public class Sqrt_of_num
{
//     public static int floorSqrt(int n) {

//         if(n < 2)return n;
//         int ans = 1;
//         for(int i= 2 ;i<=n/i;i++)
//         {
//             ans = i;
//         }
//         return ans;
//     }
    //optimal
public static int floorSqrt(int n)
{
       if(n < 2)return n;
        int l = 1,h=n;
        int index = 1;
        while(l <= h)
        {
            int mid = l+(h - l)/2;
            if(mid <= n/mid)
            {
                index = mid;
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
        return index;     
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter num ");
        int n = sc.nextInt();
        int ans = floorSqrt(n);
        System.out.println("answer is "+ans);
    }
}