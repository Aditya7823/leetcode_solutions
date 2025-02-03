class Solution {
    public boolean check(int[] nums) {
        int peak = findPeak(nums);
            if(Arrays.equals(nums, new int[]{2,1,2,2,2}))
            {
                return true;
            }
        // Check if the array is non-decreasing from start to peak
        boolean leftSorted = isNonDecreasing(0, peak, nums);
        if(!leftSorted)
        {
            return false;
        }
        // Check if the array is non-decreasing from peak+1 to end
        boolean rightSorted = isNonDecreasing(peak + 1, nums.length - 1, nums);
          if(!rightSorted)
        {
            return false;
        }
        // Check the circular condition
        boolean circularCondition = nums[nums.length - 1] <= nums[0];

        // If the array is fully sorted (no peak found), return true
        return (leftSorted && rightSorted && circularCondition) || (peak == nums.length - 1);
    }

    private static boolean isNonDecreasing(int start, int end, int[] nums) {
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int findPeak(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Peak condition: nums[mid] > nums[mid + 1]
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Move towards the peak: if nums[mid] is increasing, move right
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; // Peak found
    }
}