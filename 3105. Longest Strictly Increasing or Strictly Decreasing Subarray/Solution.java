class Solution {
    public static int longestMonotonicSubarray(int[] nums) {
        int max=0;
        int count=1;

        for(int i=0;i<nums.length-1;i++)
        {
             if(nums[i]<nums[i+1])
             {
                count++;
             }
             else{
                max =Math.max(max,count);
                count=1;
             }
        }
         max =Math.max(max,count);
        count=1;
         for(int i=0;i<nums.length-1;i++)
        {
             if(nums[i]>nums[i+1])
             {
                count++;
             }
             else{
                max =Math.max(max,count);
                count=1;
             }
        }
         max =Math.max(max,count);
        return max;

    }
    public static void main(String args[])
    {
        System.out.println(longestMonotonicSubarray(new int[]{1,2,7,4,1,-3,-6}));
    }
}