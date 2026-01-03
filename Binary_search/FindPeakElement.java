// Given an array arr of integers. A peak element is defined as an element greater than both of its neighbors.
// Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i].
// Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
// Note:
// As there can be many peak values, "true" is given as output if the returned index is a peak number, otherwise "false".
// Example 1
// Input : arr = [1, 2, 3, 4, 5, 6, 7, 8, 5, 1]
// Output: 7
// Explanation: In this example, there is only 1 peak that is at index 7.
// Example 2
// Input : arr = [1, 2, 1, 3, 5, 6, 4]
// Output: 1
// Explanation: In this example, there are 2 peak numbers at indices 1 and 5. We can consider any of them.
public class FindPeakElement {
    public static int findPeak(int arr[])
    {
        if(arr[0] > arr[1])return 0;
        if(arr[arr.length-1] > arr[arr.length-2]) return arr.length-1;
        int l=1,h=arr.length-2;
        while(l <= h)
        {
            int mid = l+(h-l)/2;
            if(arr[mid]>arr[mid-1] && arr[mid] > arr[mid+1])
            {
                return mid;
            }
            else if(arr[mid+1] > arr[mid])
            {
                l = mid + 1;
            }
            else 
            {
                h = mid - 1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println(findPeak(arr));
        
    }
    
}
