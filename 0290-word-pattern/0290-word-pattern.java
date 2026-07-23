class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        Map<Character,String> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++)
        {
            char key = pattern.charAt(i);
            if(map.containsKey(key))
            {
                String val = map.get(key);
                if(!val.equals(arr[i])) return false;
            }
            else
            {
                if(map.containsValue(arr[i])) return false;
            }
            map.put(key,arr[i]);
        }
        return true;
    }
}