class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character,Character> hash = new HashMap<>();
        for(int i=0;i<len;i++)
        {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(hash.containsKey(cs))
            {
                char ch = hash.get(cs);
                if(ch!=ct) return false;
            }
            else
            {
                if(hash.containsValue(ct)) return false;
            }
                hash.put(cs,ct);
            
        }
        return true;
    }
}