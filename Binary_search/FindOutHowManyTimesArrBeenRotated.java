// Given an integer array nums of size n, sorted in ascending order with distinct values. The array has been right rotated an unknown number of times, between 0 and n-1 (including). Determine the number of rotations performed on the array.
// Example 1
// Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
// Output: 4
// Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.
// Example 2
// Input: nums = [3, 4, 5, 1, 2]
// Output: 3
// Explanation: The original array should be [1, 2, 3, 4, 5]. So, we can notice that the array has been rotated 3 times.
public class FindOutHowManyTimesArrBeenRotated {
    public static int findAns(int arr[])
    {
       if(arr.length == 1)return 0;

       int l = 0,h=arr.length - 1;
       int ans = Integer.MAX_VALUE;
       int index = -1;
       while (l <= h) {

        int mid = l + (h-l)/2;
        if(arr[l] <= arr[h])
        {
            if(arr[l] < ans)
            {
                ans = Math.min(ans,arr[l]);
                index = l;
            }
            return index;            
        }
        if(arr[l] <= arr[mid])
        {
            if(arr[l] < ans)
            {
                ans = Math.min(ans,arr[l]);
                index = l;
            }
            l = mid + 1;
        }
        else
        {
            if(arr[mid]<ans)
            {
                ans = Math.min(ans,arr[mid]);
                index  = mid;
            }
            h = mid - 1;
        }    
        
       }
       return index;

    }
    public static void main(String[] args) {

        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(findAns(arr));
        
    }
    
}
