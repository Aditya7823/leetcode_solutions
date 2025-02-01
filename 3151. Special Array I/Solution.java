public class Solution {
    public static boolean isArraySpecial(int[] nums) {
        for(int i =0;i< nums.length-1;i++)
        {
            if(nums[i]%2==0  &&  nums[i+1]%2==0  || nums[i]%2==01  &&  nums[i+1]%2==1 )
            {
                return false;
            }        }
            return true;
    }
    public static void main(String args[])
    {
        int[] arr={1,2,3,4,5,7,9};
        System.out.println(isArraySpecial(arr));
    }
}