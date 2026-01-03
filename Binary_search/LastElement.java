public class LastElement {
    public static int findLast(int []nums,int target)
    {
        if(nums.length == 0) return -1;
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l <= h)
        {
            int mid = l+(h-l)/2;
            if(nums[mid] == target)
            {
                ans = mid;
                l = mid + 1;
            }
            else if(nums[mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
        return ans;        
    }
    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 1, 2, 3 }, target = 1;
        int ans = findLast(arr, target);
        System.out.println("the last element  position is: " + ans);     
    }    
}
