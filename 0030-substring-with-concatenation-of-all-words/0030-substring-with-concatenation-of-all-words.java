// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         HashMap<String, Integer> freq = new HashMap<>();
//         for (String word : words) {
//             freq.put(word, freq.getOrDefault(word, 0) + 1);
//         }
//         List<Integer> ans = new ArrayList<>();
//         int wordSize = words[0].length(); 
//         int totalSize = wordSize * words.length;
//         for (int start = 0; start + totalSize <= s.length(); start++) {
//             HashMap<String, Integer> curr = new HashMap<>(freq);
//             boolean flag = true;
//             for (int i = start; i < start + totalSize; i += wordSize) {
//                 String word = s.substring(i, i + wordSize);
//                 if (!curr.containsKey(word) || curr.get(word) == 0) {
//                     flag = false;
//                     break;
//                 }
//                 curr.put(word, curr.get(word) - 1);
//             }
//             if(flag)ans.add(start);
//         }
//         return ans;
//     }
// }

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (s == null || words == null || words.length == 0)
            return ans;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen)
            return ans;

        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        // Try every possible offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;
            HashMap<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (freq.containsKey(word)) {

                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink window if word appears too many times
                    while (window.get(word) > freq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Found a valid window
                    if (count == wordCount) {
                        ans.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                } else {
                    // Reset window
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }
}