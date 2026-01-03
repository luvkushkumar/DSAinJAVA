// Given an integer array nums,sorted in ascending order(with distinct values)and a target value k.The array is rotated at some pivot point that is unknown.Find the index at which k is present and if k is not present return-1.
// Example 1
// Input:nums=[4,5,6,7,0,1,2],k=0
// Output:4
// Explanation:Here,the target is 0. We can see that 0 is present in the given rotated sorted array,nums.Thus,we get output as 4,which is the index at which 0 is present in the array.
// Example 2
// Input:nums=[4,5,6,7,0,1,2],k=3
// Output:-1
// Explanation:Here,the target is 3. Since 3 is not present in the given rotated sorted array.Thus,we get the output as-1.
public class SearchInSortedArrayI {
    public static int findAns(int a[],int target)
    {
        if(a.length == 0)return -1;
        if(a.length == 1)return 0;
        
        int l =0,h=a.length;
        while(l <= h)
        {
            int mid = l+(h-l)/2;

            if(a[mid] == target)
            {
                return mid;
            }
            else if(a[l] <= a[mid])
            {
                if(a[l] <= target && target <=a[mid])
                {
                    h = mid - 1;
                }
                else 
                {
                    l = mid + 1;
                }
            }
         
        }   
        return -1;     
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2},k=0;
        int ans = findAns(arr,k);
        System.out.println("the answer is "+ans);
    }    
}
