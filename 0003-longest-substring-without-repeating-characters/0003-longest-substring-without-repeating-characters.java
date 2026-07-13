class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        HashMap<Character,Integer> hash = new HashMap<>();
        int n = s.length();
        if(n<2) return n;
        while(j<n)
        {
            hash.put(s.charAt(j), hash.getOrDefault(s.charAt(j), 0) + 1);
            while(hash.get(s.charAt(j))>1)
            {
                hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
            
        }

        return max;
    }
}