class Solution {
    class Pair{
        int start;
        int end;
        Pair(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        // List<List<Integer>> list = new ArrayList<>();
        int n = intervals.length;
        Pair[] pair = new Pair[n];
        for(int i=0;i<n;i++)
        {
            // List<Integer> ls = new ArrayList<>();
            // for(int j=0;j<2;j++)
            // {
            //     ls.add(intervals[i][j]);
            // }
            // list.add(ls);
            pair[i] = new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(pair,(a,b)->a.end - b.end);
        int lastTime = pair[0].end;
        int count = 1;
        for(int i=1;i<n;i++)
        {
            if(lastTime<=pair[i].start)
            {
                count++;
                lastTime = pair[i].end;
            }
        }
        return n-count;
    }
}