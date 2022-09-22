import java.util.*;

class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] check;
    public int solution(int[][] maps) {
        int answer = 0;
        check = new boolean[maps.length][maps[0].length];
        answer = bfs(maps, maps.length - 1, maps[0].length - 1);
        
        return answer;
    }
    
    public int bfs(int[][] maps, int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        check[0][0] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.y == y && node.x == x){
                return node.cost;
            }
            
            for(int i = 0; i < 4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if(isValidCoord(ny, nx) && !check[ny][nx] && maps[ny][nx] == 1){
                    queue.add(new Node(ny, nx, node.cost + 1));
                    check[ny][nx] = true;
                }
            }
        }
        
        return -1;
        
    }
    
    public boolean isValidCoord(int y, int x) {
        return 0 <= y && y < check.length && 0 <= x && x < check[0].length;
    }
}

class Node{
    int y;
    int x;
    int cost;
    
    public Node(int y, int x, int cost){
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}