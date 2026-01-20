// A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas. An integer h represents the total time in hours to eat all the bananas.
// Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas. If the pile contains fewer than k bananas, the monkey eats all the bananas
// in that pile and does not consume any more bananas in that hour.
// Determine the minimum number of bananas the monkey must eat per hour to finish all the bananas within h hours.
// Example 1
// Input: n = 4, nums = [7, 15, 6, 3], h = 8
// Output: 5
// Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly. So, he will take 8 hours to complete all the piles.  

// Example 2
// Input: n = 5, nums = [25, 12, 8, 14, 19], h = 5
// Output: 25
// Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly. So, he will take 5 hours to complete all the piles.

public class Koko_eating_bananas {
    public static int findMax(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int findTime(int val, int a[]) {
        int tTime = 0;
        for (int i = 0; i < a.length; i++) {
            tTime += Math.ceil((double) a[i] / val);
        }
        return tTime;
    }

    public static int minimumRateToEatBananas(int[] nums, int h) {
        // int max = findMax(nums);
        // for (int i = 1; i <= max; i++) {
        //     int totalHrs = findTime(i, nums, h);

        //     if (totalHrs <= h) {
        //         return i;
        //     }
        // }
        // return -1;
        int l = 1, hr = findMax(nums);
        int ans = -1;
        while (l <= hr) {
            int mid = l + (hr - l) / 2;
            int time = findTime(mid, nums);

            if (time <= h) {
                ans = mid;
                hr = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return ans;
    }
    public static void main(String args[]) {
       int arr[] = {7, 15, 6, 3};
       int h = 8;
       System.out.println(minimumRateToEatBananas(arr,h));
    }
}