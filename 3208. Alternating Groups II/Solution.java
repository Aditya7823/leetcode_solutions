class Solution{
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int left =0;
         if(k>n)
         {
            return 0;
         }
         int count=0;
         for(int right= 0 ;right<n+k-1;right++)
         {
            if(right>0  &&   colors[right%n]== colors[(right-1)%n])
            {
                left= right;
            }
            if(right-left>=k-1)
            {
           count++;
            }
         }
         return count;

    }
    public static void main(String args[])
    {
     
        int[] arr={
            0,1,0,0,1,0,1
        };
        int k =6;
        System.out.println(numberOfAlternatingGroups(arr,k));
    }

}