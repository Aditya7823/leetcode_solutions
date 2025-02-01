  import java.util.*;

  class code{
    private static final int[][] directions={
        {0,1},
        {0,-1},
        {-1,0},
        {1,0}
    };
 public static int largestIsland(int[][] grid) {

   int n = grid.length;
   Map<Integer, Integer> map= new HashMap<>();
    int id=2;
    int maxisland=0;
    for(int i =0;i<n;i++)
    {
        for(int j =0;j<n;j++)
        {
           if(grid[i][j]==1)
           {
            int size = dfs(grid,i ,j, id);
            map.put(id,size);
            maxisland= Math.max(maxisland,size);
            id++;
           }
        }
    }
    for(int i =0;i<n;i++)
    {
        for(int j =0;j<n;j++)
        {

           if(grid[i][j]==0)
           {
         Set<Integer> set= new HashSet<>();
          int newsize=1;
          for(int[] d: directions)
          {
            int nr = i +d[0];
            int nc= j +d[1];
            if(nr>=0 && nc>=0 && nr<n &&  nc<n  &&  grid[nr][nc]>1)
            {
                        
                        int ids = grid[nr][nc];
                        if(!set.contains(ids))
                        {
                            newsize= newsize+ map.get(ids);
                            set.add(ids);
                            
                        }

            }
          }


 maxisland= Math.max(maxisland,newsize);


           }
           
        }
    }




  return maxisland==0?n*n: maxisland;




 }
 private  static int dfs(int[][] grid, int i , int j , int id)
 {
    int n =grid.length;
    if(i<0 || j<0 || i>n-1 || j>n-1 || grid[i][j]!=1)
    {
        return 0;
    }
     grid[i][j]=id;
     int size =1;
     for(int[] d: directions)
     {
        size = size+ dfs(grid, i+d[0], j+d[1], id);
     }
     return size;
 }



  public static void main(String[] args) {
       
        // Test case 1
       
        // Test case 2
        int[][] grid2 = {
            {1, 0},
            {1, 1}
        };
        System.out.println("Largest Island Size (Test Case 2): " + largestIsland(grid2));  // Expected output: 4

        // Test case 3
         }


}