class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i =0;i<strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                ArrayList<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                map.put(key, ls);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}