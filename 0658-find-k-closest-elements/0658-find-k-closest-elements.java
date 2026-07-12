class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int j = arr.length-1;
        int i = 0;
        int idx = -1;
        if(x<arr[0]) idx=-1;
        else if(x>arr[arr.length-1]) idx = arr.length;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(arr[mid] == x)
            {
                idx = mid;
                break;
            }
            if(arr[mid]<x) i= mid+1;
            else j = mid-1;
        }
        int left = idx;
        int right = idx;
        if(idx == -1)
        {
            left = j;
            right = i;
        }
        else if (idx == arr.length) {      
            left = arr.length - 1;
            right = arr.length;
        } else {
            left = idx;
            right = idx + 1;                 
        }

        int len = 0;
        while((left>=0 || right<arr.length) && len<k)
        {
            if (left < 0) {
                ans.add(arr[right++]);
            } 
            else if (right >= arr.length) {
                ans.add(arr[left--]);
            } 
            else{
                int noleft = Math.abs(arr[left]-x);
                int noright = Math.abs(arr[right]-x);
                if(noleft<=noright)
                {
                    ans.add(arr[left]);
                    left--;
                }
                else{
                    ans.add(arr[right]);
                    right++;
                }
            }
            len++;
        }
        Collections.sort(ans);
        return ans;

    }
}