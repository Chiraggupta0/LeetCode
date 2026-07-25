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
        HashSet<Integer> hash = new HashSet<>();
        while(!hash.contains(n))
        {
            hash.add(n);
            n = sum(n);
            if(n == 1) return true;
        }
        return false;
    }
}