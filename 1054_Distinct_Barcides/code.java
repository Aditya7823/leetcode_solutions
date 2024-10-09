class Solution {

    class Bar{
        int barcode;
        int freq;
        Bar(int barcode,int freq)
        {
            this.barcode= barcode;
            this.freq= freq;
        }
    }
    public int[] rearrangeBarcodes(int[] b) {
        

        Map<Integer,Integer> map = new HashMap<>();
        for(int n : b)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Bar> pq= new PriorityQueue<>(
            (a,bk)-> bk.freq-a.freq 
        );
        for(int key: map.keySet()){
            pq.offer(new Bar(key,map.get(key)));
        }
        Bar prev= null;
        for(int i=0;i<b.length;i++)
 {



        Bar curr= pq.poll();
        b[i]=curr.barcode;
        curr.freq--;
        
        if(prev!=null)
        {
            pq.offer(prev);
        }
        if(curr.freq>0)
        {
            prev= curr;
        }
        else 
          prev= null;

      }

  return b;      
    }
   
}