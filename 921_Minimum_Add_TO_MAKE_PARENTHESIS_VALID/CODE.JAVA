class Solution {
    public int minAddToMakeValid(String s) {
        int other=0;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c=='(')
            {
                stack.push('(');
            }

            else{
                if(stack.size()==0)
                {
                    other++;
                }
                else{
                    stack.pop();
                }
            }
           
        }
         return stack.size()+other;
    }
}