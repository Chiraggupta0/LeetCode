class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int rem = target-nums[i];
            if(hash.containsKey(rem))
            {
                return new int[] {hash.get(rem),i};
            }
            hash.put(nums[i],i);
        }
        return new int[] {0,0};
    }
}