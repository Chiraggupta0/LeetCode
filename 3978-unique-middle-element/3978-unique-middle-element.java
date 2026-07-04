class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int idx = nums.length/2;
        int num = nums[idx];
        for(int i=0;i<nums.length;i++)
            {
                if(i == idx) continue;
                if(nums[i] == num) return false;
            }

        return true;
    }
}