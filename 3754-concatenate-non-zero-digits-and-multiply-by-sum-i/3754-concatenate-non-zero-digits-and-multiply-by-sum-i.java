class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;
        String s = Integer.toString(n);
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        int sum=0;
        for(int i=0;i<l;i++)
        {
            char c = s.charAt(i);
            if(c!='0')
            {
                sb.append(c);
                sum+=c- '0';
            }
        }
        int no = Integer.parseInt(sb.toString());
        return (long)no*sum;

    }
}