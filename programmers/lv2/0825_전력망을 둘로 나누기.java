import java.util.*;

class Solution {
    public int[][] map;
    public boolean[] visit;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n + 1][n + 1];
        
        for(int i = 0; i < wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a][b] = 0;
            map[b][a] = 0;
            
            answer = Math.min(answer, bfs(n, a));
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int n, int start){
        Queue<Integer> queue = new LinkedList<>();
        visit = new boolean[n + 1];
        int cnt = 1;
        queue.add(start);
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            visit[num] = true;
            
            for(int i = 1; i <= n; i++){
                if(!visit[i] && map[num][i] == 1){
                    queue.add(i);
                    cnt++;
                }
            }
        }
        
        return (int)Math.abs((n-cnt) - cnt);
    }
}