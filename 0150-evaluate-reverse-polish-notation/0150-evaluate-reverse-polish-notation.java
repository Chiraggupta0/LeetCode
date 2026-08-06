class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for(int i=0;i<n;i++)
        {
            String ch = tokens[i];
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))
            {
                int no2 = stack.pop();
               
                int no1 = stack.pop();
              
                if (ch.equals("+"))
                {
                    int no3 = no1+no2;
                    stack.push(no3);
                }
                if (ch.equals("-"))
                {
                    int no3 = no1-no2;
                    stack.push(no3);
                }
                if (ch.equals("*"))
                {
                    int no3 = no1*no2;
                    stack.push(no3);
                }
                if (ch.equals("/"))
                {
                    int no3 = no1/no2;
                    stack.push(no3);
                }
            }
            else
            {
                int orgno = Integer.parseInt(ch);
                stack.push(orgno);
            }

        }
        return stack.pop();
    }
}