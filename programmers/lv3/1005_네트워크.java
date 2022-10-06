import java.util.*;

class Solution {
    public static boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++) {
            if(!check[i]) {
                dfs(computers, i, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    
    public void dfs(int[][] computers, int start, int n) {
        check[start] = true;
        
        for(int i = 0; i < n; i++){
            if(computers[start][i] == 1 && !check[i]) {
                dfs(computers, i, n);
            }
        }
        
    }
}