// Given n roses and an array nums where nums[i] denotes that the 'ith' rose will bloom on the nums[i]th day, only adjacent bloomed roses can be picked to make a bouquet. Exactly k adjacent bloomed roses are required to make a single bouquet. Find the minimum number of days required to make at least m bouquets, each containing k roses. Return -1 if it is not possible.
// Example 1
// Input: n = 8, nums = [7, 7, 7, 7, 13, 11, 12, 7], m = 2, k = 3
// Output: 12
// Explanation: On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

// Example 2
// Input: n = 5, nums = [1, 10, 3, 10, 2], m = 3, k = 2
// Output: -1
// Explanation: If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.

public class MiniDaysToMakeMBouquets {
    public static int findMax(int nums[]) {
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }
        return maxVal;
    }

    public static int findMini(int nums[]) {
        int minV = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minV) {
                minV = nums[i];
            }
        }
        return minV;
    }
    public static boolean findBouquets(int val, int nums[], int k, int m) {
        int NoOfBouquest = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= val) {
                count++;
            } else {

                NoOfBouquest += count / k;
                count = 0;

            }
        }
        NoOfBouquest += count / k;
        return NoOfBouquest >= m ? true : false;
    }

    public static int roseGarden(int[] nums, int k, int m) {
        if (nums.length < (m * k))
            return -1;
        // for (int i = findMini(nums); i <= findMax(nums); i++) {
        //     boolean bouquets = findBouquets(i, nums, k, m);
        //     if (bouquets)
        //         return i;
        // }
        // return -1;
        int low = findMini(nums), high = findMax(nums);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (findBouquets(mid, nums, k, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = { 7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2 ,k = 3;
        System.out.println(roseGarden(arr, k, m));        
    }
    
}
