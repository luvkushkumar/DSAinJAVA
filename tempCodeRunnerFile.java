// Given an integer array nums. Return the number of reverse pairs in the array.
// An index pair (i, j) is called a reverse pair if:
// 0 <= i < j < nums.length
// nums[i] > 2 * nums[j]
// Examples:
// Input: nums = [6, 4, 1, 2, 7]
// Output: 3
// Explanation:
// The reverse pairs are:
// (0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
// (0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
// (1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1
// Input: nums = [5, 4, 4, 3, 3]
// Output: 0
// Explanation:
// No pairs satisfy both the conditons.
public class ReversePairs {
    public static long merge(int nums[], int low, int mid, int high, int[] temp) {
        long count = 0;
        int left = low;
        int right = mid + 1;
        int i = low;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[i++] = nums[left++];
            } else {
                count += (mid - left + 1);
                temp[i++] = nums[right++];
            }
        }

        while (left <= mid)
            temp[i++] = nums[left++];
        while (right <= high)
            temp[i++] = nums[right++];

        for (int j = low; j <= high; j++) {
            nums[j] = temp[j];
        }
        return count;
    }

    public static long countPairs(int nums[], int low, int mid, int high) {
        long count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public static long mergeSort(int nums[], int low, int high, int temp[]) {
        long count = 0;
        if (low >= high)
            return count;

        int mid = low + (high - low) / 2;
        count += mergeSort(nums, low, mid, temp);
        count += mergeSort(nums, mid + 1, high, temp);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high, temp);
        return count;
    }

    public static int reversePairs(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int temp[] = new int[nums.length];
        long count = mergeSort(nums, 0, nums.length - 1, temp);
        return (int) count;
    }

    public static void main(String []args)
    {
        int nums[] = {6, 4, 1, 2, 7};
        int n = nums.length;
        System.out.println(reversePairs(nums));
    }
    
}
