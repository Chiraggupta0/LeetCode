class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        String[] sb = new String[numRows];
        for(int i=0;i<numRows;i++)
        {
            sb[i] = "";
        }
        int i=0;
        while(i<n)
        {
            for(int idx=0;idx<numRows && i<n ;idx++)
            {
                sb[idx]+= s.charAt(i);
                i++;
            }
            for(int idx=numRows-2;idx>0 && i<n ;idx--)
            {
                sb[idx] +=s.charAt(i);
                i++;
            }
        }
        String ans="";
        for(String st:sb)
        {
            ans+=st;
        }
        return ans;
    }
}