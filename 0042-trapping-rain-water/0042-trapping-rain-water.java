class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = 0;
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int[] rightMax = new int[n];
        rightMax[0] = 0;
        for(int i=1;i<n;i++)
        {
            left = Math.max(left,height[i-1]);
            leftMax[i] = left;
        }
        for(int i=n-2;i>=0;i--)
        {
            right = Math.max(right,height[i+1]);
            rightMax[i] = right;
        }
        int count = 0;
        for(int i=0;i<n;i++)
        {
            int min = Math.min(leftMax[i],rightMax[i]);
            if((min - height[i])>0)
            {
                count += (min - height[i]);
            }
        }
        return count;
    }
}