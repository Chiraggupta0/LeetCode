class Solution {
    public String intToRoman(int num) {
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();
        int times = 0;
        for(int i=0;i<13;i++)
        {
            if(num == 0) break;
            // if(values[i]>num) continue;
            times = num/values[i];
            for(int j=0;j<times;j++)
            {
                sb.append(symbols[i]);
            }
            num = num%values[i];
        }
        return sb.toString();
    }
}