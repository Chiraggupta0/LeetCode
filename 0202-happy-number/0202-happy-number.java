class Solution {
    static int sum(int num)
    {
        int sm = 0;
        while(num>0)
        {
            int rem = num%10;
            sm +=(rem*rem);
            num/=10;
        }
        return sm;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow=sum(slow);
            fast = sum(sum(fast));
        }while(slow!=fast);
        return slow == 1;
    }
}