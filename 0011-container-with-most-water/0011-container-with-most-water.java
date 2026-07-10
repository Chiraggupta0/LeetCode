class Solution {
    public int maxArea(int[] height) {
        int max =0;
        int n = height.length;
        int j=n-1;
        int i=0;
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=n-1;j>=0;j--)
        //     {
        //         int w = j-i;
        //         int h = Math.min(height[i],height[j]);
        //         max = Math.max(max,w*h);
        //     }
        // }
        while(i<j)
        {
            int w = j-i;
            int h = Math.min(height[i],height[j]);
            max = Math.max(max,w*h);
            if(height[i]>height[j])
            {
                j--;
            }
            else i++;
        }
        return max;
    }
}