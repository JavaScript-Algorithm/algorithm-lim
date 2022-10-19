import java.util.*;

class Solution {
    
    public static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[costs.length];
        
        Arrays.sort(costs, (int[] c1, int c2[]) -> (c1[2] - c2[2]));
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int[] arr : costs) {
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];
            
            int fromParent = findParent(from);
            int toParent = findParent(to);
            
            if(fromParent == toParent){
                continue;
            }
            
            answer += cost;
            parent[toParent] = fromParent;
        }
       
        
        return answer;
    }
    
    public int findParent(int node) {
		if(parent[node] == node) return node;
		return parent[node] = findParent(parent[node]);
	}
}