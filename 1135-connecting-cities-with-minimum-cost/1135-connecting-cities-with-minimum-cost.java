class Solution {
    int[] parents;

    public int minimumCost(int n, int[][] connections) {

        int cost = 0;
        int edgesUsed = 0;

        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        this.parents = new int[n+1];

        for(int i = 0; i <= n; i++) parents[i] = i; // every element in the parent array points to itself

        for(int[] c : connections){
            int v1 = c[0], v2 = c[1];
            if(find(v1) != find(v2)){
                cost += c[2];
                union(v1, v2);
                edgesUsed++; // Track number of edges added to MST
            }
        }

        // A spanning tree of n nodes needs exactly n-1 edges
        return edgesUsed == n-1 ? cost : -1;
    }

    /**
     * Find() – It helps to determine which subset a particular element belongs to.
     * The find method uses the parent array to recursively find the root of a vertex. 
     * For each vertex, the parent  array holds a pointer (index) to the parent of that vertex.
     * The root vertex is found when the find method comes to a vertex in the parent array that points to itself. 
     */
    private int find(int vertex) {
        while(this.parents[vertex] != vertex) vertex = this.parents[vertex];
        return vertex;
    }

    /**
     * Union() – It helps to check whether a graph is cyclic or not. And helps connect or join two subsets.
     * When an edge is added to the MST, the union method uses the parent array to merge (union) two trees.
     */
    private void union(int v1, int v2) {
        int rootV1 = find(v1);
        int rootV2 = find(v2);
        
        if(rootV1 != rootV2) this.parents[rootV2] = rootV1; // Take union by assigning rootV1 as the parent of rootV2
    }
}