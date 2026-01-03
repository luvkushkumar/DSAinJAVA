public class FindOccurrence {
    public static int findPos(int nums[], int target, boolean flag) {
        int l = 0;
        int h = nums.length - 1;
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (flag) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static int findAns(int[] nums, int target) {
        int first = findPos(nums, target, true);
        if (first == -1)
            return 0;
        int last = findPos(nums, target, false);

        return last - first + 1;
    }
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 2, 3};
        int target = 1;

        System.out.println(findAns(arr,target));

    }
}
