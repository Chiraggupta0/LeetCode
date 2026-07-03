class Solution {
    public int strStr(String haystack, String needle) {
        int l = 0;
        int r = 0;
        int lengthHay = haystack.length();
        int lengthNeedle = needle.length();
        while(l<lengthHay && r<lengthNeedle)
        {
            if(haystack.charAt(l) == needle.charAt(r))
            {
                l++;
                r++;
                // continue;
                if(r == lengthNeedle)
                {
                    return l-r;
                }
            }
            else {
                l = l - r + 1;   
                r = 0;    
            }
            
        }
        
        return -1;
    }
}