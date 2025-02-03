class Solution2 {
    public  static boolean check(int[] nums) {
       

       int count=0;
       for(int i =0;i<nums.length;i++)
       {
        if(nums[i]>nums[(i+1)%nums.length])
        {
            count++;
        }
         }

     return count<=1;
    }
    public static void main(String args[])
    {
     System.out.println(check(new int[]{1,5,3,5}));
    }
}

//  int count = 0; 
        // 
        // for (int i = 0; i < nums.length; i++) {
        //     // If the current element is greater than the next element
        //     if (nums[i] > nums[(i + 1) % nums.length]) {
        //         count++;
        //     }
        // }
        
       
        // return count <= 1;