class Solution {
    // HashSet<String> hash = new HashSet<>();
    // int max = 0;
    // public void func(String text1,int idx,StringBuilder sb)
    // {
    //     if(idx == text1.length())
    //     {
    //         hash.add(sb.toString());
    //         return;
    //     }
    //     sb.append(text1.charAt(idx));
    //     func(text1,idx+1,sb);
    //     sb.deleteCharAt(sb.length()-1);
    //     func(text1,idx+1,sb);
        
    // }
    // public void func2(String text1,int idx,StringBuilder sb)
    // {
    //     if(hash.contains(sb.toString()))
    //     {
    //         max = Math.max(max,sb.length());
    //         // return;
    //     }
    //     if(idx == text1.length())
    //     {
    //         return;
    //     }
    //     sb.append(text1.charAt(idx));
    //     func2(text1,idx+1,sb);
    //     sb.deleteCharAt(sb.length()-1);
    //     func2(text1,idx+1,sb);
        
    // }
    public int rec(String t1,String t2, int i,int j,int[][]dp)
    {
        if(i == t1.length() || j == t2.length())
        {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j))
        {
            return 1+rec(t1,t2,i+1,j+1,dp);
        }
        return dp[i][j]=Math.max(rec(t1,t2,i+1,j,dp),rec(t1,t2,i,j+1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // StringBuilder sb = new StringBuilder();
        // if(text1.length() >= text2.length()) {
        //     func(text1, 0, new StringBuilder());
        //     func2(text2, 0, new StringBuilder());
        // } else {
        //     func(text2, 0, new StringBuilder());
        //     func2(text1, 0, new StringBuilder());
        // }
        // return max;
        int[][]dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return rec(text1,text2,0,0,dp);
    }
}