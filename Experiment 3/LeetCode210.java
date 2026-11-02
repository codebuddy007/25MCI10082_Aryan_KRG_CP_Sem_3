class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDeg= new int[numCourses];

        for(int i = 0; i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int course = edge[0];
            int preq = edge[1];
            graph.get(preq).add(course);
            inDeg[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i <numCourses;i++){
            if(inDeg[i]==0) q.offer(i);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            order[index++]=cur;

            for(int n:graph.get(cur)){
                inDeg[n]--;
                if(inDeg[n]==0)q.offer(n);
            }
        }

return index== numCourses? order : new int[0];
        }
    
}
