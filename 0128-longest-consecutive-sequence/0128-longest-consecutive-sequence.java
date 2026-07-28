class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        int ans = 0;
        if(nums.length == 0) return 0;
        for(int i=0;i<nums.length;i++)
        {
            hash.add(nums[i]);
        }
        for(int num:hash)
        {
            int count = 1;
            if(!hash.contains(num-1))
            {
                while(hash.contains(num+1))
                {
                    num++;
                    count++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}