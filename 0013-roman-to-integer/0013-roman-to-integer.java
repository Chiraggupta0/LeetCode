class Solution {
    public int romanToInt(String s) {
        int ans=0;
        int number=0;
        int prev=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            switch(s.charAt(i))
            {
                case 'M' -> number=1000;
                case 'D' -> number=500;
                case 'C' -> number=100;
                case 'L' -> number=50;
                case 'X' -> number=10;
                case 'V' -> number=5;
                case 'I' -> number=1;
            }
            if(number<prev)
            {
                ans-=number;
            }
            else{
                ans+=number;
            }
            prev=number;
        }
        return ans;
    }
}