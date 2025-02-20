import java.util.HashSet;
import java.util.Set;
class Solution {
    public  static String findDifferentBinaryString(String[] nums) {
  Set<String> set = new HashSet<>();
  for(String s: nums)

  {
    set.add(s);
  }
    
    int n = nums[0].length();
    return function(set,n,new StringBuilder());


    }
    private static String function(Set<String> set ,int length, StringBuilder sb)
    {   
        if(sb.length()==length)
        {
            if(!set.contains(sb.toString()))
            {
                return sb.toString();
            }else{
                return null;
            }
            

        }
        sb.append("0");
        String res= function(set,length,sb);
        if(res!=null)
        {
            return res;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("1");
        res= function(set,length,sb);
        if(res!=null)
        {
            return res;
        }
        sb.deleteCharAt(sb.length()-1);
        return null;
    }
    public static void main(String[] args)
    {
        String[] arr= {"0111001000","1010101010","0000000000"};
        System.out.println(findDifferentBinaryString(arr));
    }
    
    
    
}