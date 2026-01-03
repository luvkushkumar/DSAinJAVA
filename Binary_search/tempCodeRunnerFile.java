// Given an array nums sorted in non-decreasing order. Every number in the array except one appears twice. Find the single number in the array.
// Example 1
// Input :nums = [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
// Output:4
// Explanation: Only the number 4 appears once in the array.
// Example 2
// Input : nums = [1, 1, 3, 5, 5]
// Output:3
// Explanation: Only the number 3 appears once in the array.
public class SingleElementInArray {
    public static int findAns(int arr[])
    {
        if(arr[0] != arr[1])return arr[0];
        if(arr[arr.length-1] != arr[arr.length-2])return arr[arr.length-1];

        int l = 1,h=arr.length-2;
        while (l<=h) {
            int mid = l+(h-l)/2;
            if(arr[mid-1] != arr[mid] && arr[mid] != arr[mid+1])
            {
                return arr[mid];
            }            
            if((mid%2 ==1 && arr[mid] == arr[mid-1]) || (mid%2 == 0 && arr[mid] == arr[mid +1]))
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
        
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(findAns(arr));
    }
    
}
