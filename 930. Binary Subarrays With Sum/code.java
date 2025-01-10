class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0; 

 
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = 0;

      
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                if ((prefix[j] - prefix[i]) == goal) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
