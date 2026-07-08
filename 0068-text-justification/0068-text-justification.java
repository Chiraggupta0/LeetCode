// class Solution {
//     public List<String> fullJustify(String[] words, int maxWidth) {
//         int n = words.length;
//         int len = 0;
//         int word = 0;
//         int sp = 0;
//         int h=0;
//         List<String> ls = new ArrayList<>();
//         for(int i=0;i<n;i++)
//         {
//             len = len + words[i].length() + sp++;
            
//             word+=1;
//             int space = word-1;
//             StringBuilder s = new StringBuilder();
//             for(int j=0;j<(2*word)-1;j++)
//             {
//                 if(j%2 == 0)
//                 {
//                     s.append(words[h++]);
//                 }
//                 else{
//                     int q = maxWidth-len;
//                     int perSpace =(int) Math.ceil(q)/space;
//                     for(int k=0;k<perSpace;k++)
//                     {
//                         s.append(" ");
//                     }
//                     space--;
//                     q-=perSpace;
//                 }
//             }
//             len = 0;
//             sp=0;
//             word = 0;
//             String str = s.toString();
//             ls.add(str);
//         }
//         return ls;
//     }
// }


import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        int n = words.length;
        int idx = 0;
        List<String> ans = new ArrayList<>();

        while (idx < n) {

            StringBuilder sb = new StringBuilder();

            int wordCount = 0;
            int charCount = 0;
            int wordWithoutSpaceCount = 0;
            int lastI = -1;

            // Greedily take words
            for (int i = idx; i < n; i++) {

                if (wordCount > 0)
                    charCount++;

                wordWithoutSpaceCount += words[i].length();
                wordCount++;

                charCount += words[i].length();

                if (charCount > maxWidth) {
                    lastI = i;
                    break;
                }
            }

            if (lastI != -1) {
                wordWithoutSpaceCount -= words[lastI].length();
                wordCount--;
            }

            int t = idx;

            // last line?
            boolean isLastLine = (lastI == -1);

            // ---------------- LAST LINE ----------------
            if (isLastLine) {

                while (t < n) {

                    sb.append(words[t]);

                    if (t != n - 1)
                        sb.append(' ');

                    t++;
                }

                while (sb.length() < maxWidth)
                    sb.append(' ');

                ans.add(sb.toString());
                break;
            }

            // ---------------- SINGLE WORD ----------------
            if (wordCount == 1) {

                sb.append(words[t]);

                while (sb.length() < maxWidth)
                    sb.append(' ');

                ans.add(sb.toString());

                idx = t + 1;
                continue;
            }

            // ---------------- NORMAL JUSTIFICATION ----------------

            int emptySpace = maxWidth - wordWithoutSpaceCount;

            int gaps = wordCount - 1;

            int baseSpace = emptySpace / gaps;

            int extraSpace = emptySpace % gaps;

            for (int i = 0; i < wordCount; i++) {

                sb.append(words[t]);
                t++;

                if (i == wordCount - 1)
                    break;

                for (int j = 0; j < baseSpace; j++)
                    sb.append(' ');

                if (extraSpace > 0) {
                    sb.append(' ');
                    extraSpace--;
                }
            }

            ans.add(sb.toString());

            idx = t;
        }

        return ans;
    }
}