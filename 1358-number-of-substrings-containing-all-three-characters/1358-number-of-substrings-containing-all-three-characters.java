class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();

        int left = 0;
        int ans = 0;

        int a = 0, b = 0, c = 0;

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == 'a') a++;
            else if (s.charAt(right) == 'b') b++;
            else c++;

            while (a > 0 && b > 0 && c > 0) {

                ans += n - right;

                if (s.charAt(left) == 'a') a--;
                else if (s.charAt(left) == 'b') b--;
                else c--;

                left++;
            }
        }

        return ans;
    }
}