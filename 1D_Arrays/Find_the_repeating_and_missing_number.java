// Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
// Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
// Note: You are not allowed to modify the original array.
// Examples:
// Input: nums = [3, 5, 4, 1, 1]
// Output: [1, 2]
// Explanation:
// 1 appears two times in the array and 2 is missing from nums
// Input: nums = [1, 2, 3, 6, 7, 5, 7]
// Output: [7, 4]
// Explanation:
// 7 appears two times in the array and 4 is missing from nums.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_the_repeating_and_missing_number {
    public static void main(String args[])
    {
        int arr[] = {3, 5, 4, 1, 1};
        int n = arr.length;
        int missing = -1,repeating = -1;        
        // brute force:-
        // Arrays.sort(arr);
        // for(int i=1;i<=n;i++)
        // {
        //         int count=0;
        //         for(int j=0;j<n;j++)
        //         {
        //             if(i == arr[j])
        //             {
        //                 count++;
        //             }
        //         }
        //         if(count == 0)missing = i;
        //         else if(count == 2)repeating = i;

        //         if(missing != -1 && repeating != -1)break;                
        // }
        // System.out.println("missing "+missing+" and "+"repeating "+repeating);

/*----------------------------------------------------------------------------------------------- */
        //better approach
        // int dummy[]  = new int[n+1];
        // for(int i=0;i<n;i++)
        // {
        //     dummy[arr[i]]++;
        
        // }
        // for(int i=1;i<=n;i++)
        // {
        //     if(dummy[i] == 0)missing = i;
        //     else if(dummy[i] == 2)repeating = i;

        //     if(missing != -1 && repeating != -1)break;
        // }
        // System.out.println("missing " + missing + " and " + "repeating " + repeating);

/*------------------------------------------------------------------------------------------------ */
        //BEST approach(Mathematical approach)
//x = repeating and y = missing
// sum of array - sum of natural n numbers(x-y)
//sum of square of array elements - sum of square of natural numbers (x2 - y2)i.e.,squaring 

long SN = (n*(n+1)/2);
long S2N = (n*(n+1)*(2*n+1))/6;
long S=0L ,S2=0L;
for(int i=0;i<n;i++)
{
    S += arr[i];
    S2 += ((long)arr[i]*(long)arr[i]);
}
long x_sub_y = S-SN;
long x2_sub_y2 = S2-S2N;

long x_plus_y = x2_sub_y2/x_sub_y;
long x = (x_plus_y+x_sub_y)/2;
long y = (x_plus_y - x);

System.out.println("missing " + y + " and " + "repeating " + x);



    }
}
