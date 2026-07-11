class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>>ans = new ArrayList<>();
        for(int i=0;i<n-2;)
        {

            
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0) 
                {
                    List<Integer>ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    ans.add(ls);
                    int jval = nums[j];
                    while(j<k && nums[j]==jval)
                    {
                        j++;
                    }
                    int kval = nums[k];
                    while(k>i && nums[k] == kval)
                    {
                        k--;
                    }
                }
                else if(sum<0)
                {
                    j++;
                }
                else k--;
                
            }
            int ival = nums[i];
            while(i<n && nums[i] == ival)
            {
                i++;
            }
        }
        return ans;
    }
}