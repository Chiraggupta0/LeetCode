// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         if(nums.length<=2)
//         {
//             int sum = nums[0]+nums[1];
//             if(sum == target) return 2;
//         }
//         int i=0;
//         int j=1;
//         int s = nums[i];
//         int min = Integer.MAX_VALUE;
//         while(j<nums.length)
//         {
//             if(s+nums[j] >= target){
//                 min = Math.min(min,j-i+1);
//             }
//             if(s+nums[j]<target)
//             {
//                 s+=nums[j];
//                 j++;
//                 continue;
//             }
//             else
//             {
//                 s-=nums[i];
//                 s+=nums[j];
//                 i++;
//                 j++;
//                 continue;
//             }
            
//         }
//         return min;
//     }
// }

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;
        int s = 0;
        int min = Integer.MAX_VALUE;

        while (j < nums.length) {

            s += nums[j];

            while (s >= target) {
                min = Math.min(min, j - i + 1);
                s -= nums[i];
                i++;
            }

            j++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}