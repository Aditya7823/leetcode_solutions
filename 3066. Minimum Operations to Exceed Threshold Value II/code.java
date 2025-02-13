class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue= new  PriorityQueue<>();
        for(int n: nums)
        {
            queue.offer((long)n);
        }
        int count=0;
        long first,second,ans;
        while( queue.peek() < k )
        {
             first = queue.poll();
            if(!queue.isEmpty())
            {

          
             second = queue.poll();
             ans= Math.min(first, second)*2+Math.max(first, second);
            
            queue.offer(ans);
            count++;
              }
              else {
                break;
              }

        }
        return count;
    }
}