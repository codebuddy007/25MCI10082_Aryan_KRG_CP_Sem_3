class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<List<int[]>> gph = new ArrayList<>();
        for(int i =0; i<n;i++){
            gph.add(new ArrayList<>());
        }
        for(int[] road: roads){
            int u= road[0];
            int v = road[1];
            int w = road[2];
            gph.get(u).add(new int[]{v,w});
            gph.get(v).add(new int[]{u,w});
        }
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        long[] ways = new long[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));

        dist[0]=0;
        ways[0]=1;
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long d= curr[0];
            int u = (int) curr[1];

            if(d>dist[u]) continue;

            for(int[] neighbor : gph.get(u)){
                int v = neighbor[0];
                long wt = neighbor[1];

                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    ways[v]=ways[u];
                    pq.offer(new long[]{dist[v],v});
                }
                else if(dist[u]+wt==dist[v]){
                    ways[v]=(ways[v]+ways[u])%MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}
