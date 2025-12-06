public class Count_inversions {
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

    public static long mergeSort(int nums[], int low, int high, int temp[]) {
        long count = 0;
        if (low >= high)
            return count;
        int mid = low + (high - low) / 2;
        count += mergeSort(nums, low, mid, temp);
        count += mergeSort(nums, mid + 1, high, temp);
        count += merge(nums, low, mid, high, temp);
        return count;
    }

    public static long numberOfInversions(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int temp[] = new int[nums.length];
        long count = mergeSort(nums, 0, nums.length - 1, temp);
        return count;
    }

    public static void main(String[] args) {

        int nums[] = { 5, 3, 2, 4, 1 };
        long ans = numberOfInversions(nums);
        System.out.println("the answer is " + ans);

    }
}
