class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {revadj.add(new ArrayList<>()); ans.add(new ArrayList<>());}
        for(int[] edge: edges){
            revadj.get(edge[1]).add(edge[0]);
        }
        for(int i = 0;i < n; i++){
            Queue<Integer> q = new LinkedList<>();
            boolean vis[] = new boolean[n];
            q.offer(i);
            vis[i] = true;
            while(!q.isEmpty()){
                int node = q.poll();
                if(node != i) ans.get(i).add(node);
                for(int adjNode: revadj.get(node)) {
                    if(!vis[adjNode]){
                        vis[adjNode] = true;
                        q.offer(adjNode);
                    }
                }
            }
            Collections.sort(ans.get(i));
        }
        return ans;
    }
}

================================================================================================

  class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int indegree[] = new int[n];
        ArrayList<HashSet<Integer>> set = new ArrayList<>(); //to avoid repetition of parent node

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            set.add(new LinkedHashSet<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int it: adj.get(curr)){
                //inserting immediate parent node to each child of current node
                set.get(it).add(curr);
                
                //adds all the ancestors of the current node
                for(int it2: set.get(curr)) set.get(it).add(it2);

                //adding to queue if indegree ==0
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        for(int i = 0; i < n; i++){
            ans.add(new ArrayList<Integer>(set.get(i)));
            Collections.sort(ans.get(i));
        }
        return ans;
    }
}
