class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) {q.offer(new int[]{i, j});}
            }
        }
        int distance[][] = new int[n][m];
        int delRow[] = {+1, 0, -1, 0};
        int delCol[] = {0, +1, 0, -1};
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                int[] cell = q.poll();
                int ro = cell[0], co = cell[1];
                for(int i = 0; i < 4; i++){
                    int row = ro + delRow[i];
                    int col = co + delCol[i];
                    if(boundaryCheck(row, col, n, m) && grid[row][col] == 0 && distance[row][col] == 0) {
                        q.offer(new int[]{row, col});
                        distance[row][col] = dist + 1;
                    }
                }
            }
            dist++;
        }
        return dist - 1 == 0 ? -1: dist - 1;
    }
    public boolean boundaryCheck(int row, int col, int n, int m){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
