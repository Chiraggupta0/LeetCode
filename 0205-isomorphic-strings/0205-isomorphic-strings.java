class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character,Character> hash = new HashMap<>();
        Map<Character,Character> mpp = new HashMap<>();
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
                hash.put(cs,ct);
            }
            if(mpp.containsKey(ct))
            {
                char c = mpp.get(ct);
                if(c!=cs) return false;
            }
            else
            {
                mpp.put(ct,cs);
            }
        }
        return true;
    }
}