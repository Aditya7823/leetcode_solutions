class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

    int[][] ans=new int[m][n];
     Set<String> wallset= new HashSet<>();
     Set<String> guardset= new HashSet<>();
     for(int[] arr:  guards)
     {
        guardset.add(arr[0]+","+arr[1]);
     }
      for(int[] arr:  walls)
     {
        wallset.add(arr[0]+","+arr[1]);
     }
     for(int[]  guard: guards)
     {
        blockguard(guard[0],guard[1],m,n,ans, wallset,guardset);
     }

 int count=0;
     for(int i =0;i<m;i++)
     {
        for(int j =0;j<n;j++)
        {
            if(!ans[i][j] && !wallset.contains(ans[i][j]) && !guardset.contains(ans[i][j]))
            {
                count++;
            }
        }
     }



return count ;

    }
    private static void blockguard(int r, int c , int m , int n ,boolean[][] ans, Set<String> wallset, Set<String> guardset)
    {

     // backword look
       for(int i= c-1;i>=0;i--)
       {
        String str=  r+i;
        if(wallset.contains(str)|| guardset.contains(str))
        {
        break;
        }
        ans[r][i]=true;
       }
       // forward look 
       for(int i =c+1;i<n;i++)
       {
        String str=  r+i;
        if(wallset.contains(str)|| guardset.contains(str))
        {
        break;
        }
        ans[r][i]=true;
       }
      
   //  looking up  
   for(int i = r;i>=0;i--)
   {
      String str=  i+c;
        if(wallset.contains(str)|| guardset.contains(str))
        {
        break;
        }
        ans[i][c]=true;
   }
   // looking downward
   for(int i = r+1;r<m;i++)
   {
      String str=  i+c;
        if(wallset.contains(str)|| guardset.contains(str))
        {
        break;
        }
        ans[i][c]=true;
   }




    }



    }