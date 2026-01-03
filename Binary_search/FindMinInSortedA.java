// Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.
// Example 1
// Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
// Output: 0
// Explanation: Here, the element 0 is the minimum element in the array.
// Example 2
// Input : nums = [3, 4, 5, 1, 2]
// Output: 1
// Explanation:Here, the element 1 is the minimum element in the array.
public class FindMinInSortedA {
    public static int findMin(int arr[])
    {
        if(arr.length == 1)return arr[0];
        int l=0,h=arr.length-1;
        int ans = Integer.MAX_VALUE;
        while(l <= h)
        {
            int mid = l+(h-l)/2;
            if(arr[l] <= arr[h])
            {
                ans = Math.min(ans,arr[l]);
                break;
            }
            if(arr[l] <= arr[mid])
            {
                ans = Math.min(arr[l],ans);
                l = mid + 1;
            }
            else 
            {
                ans = Math.min(arr[mid],ans);
                h = mid - 1;    
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {

        int arr[] = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(findMin(arr));
        
    }
    
}
