class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>>st = new HashSet<>();
        
        for(int i=0;i<n;i++)
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
                    Collections.sort(ls);
                    st.add(ls);
                    j++;
                    k--;
                }
                else if(sum<0)
                {
                    j++;
                }
                else k--;
            }
        }
        return new ArrayList<>(st);
    }
}