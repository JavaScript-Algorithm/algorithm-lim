import java.util.*;

class Solution {
    public static boolean[][] check;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        check = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !check[i][j]){
                    numberOfArea++;
                    check[i][j] = true;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, i, j, m, n));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int[][] picture, int y, int x, int m, int n){
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        Queue<Node> queue = new LinkedList<>();
       
        int count = 0;

        queue.add(new Node(y, x));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            count++;
            
            for(int i = 0; i < 4; i++){
                int ny = dy[i] + node.y;
                int nx = dx[i] + node.x;
                
                if(isValid(ny, nx, m, n) && picture[ny][nx] == picture[y][x] && !check[ny][nx]){
                    check[ny][nx] = true;
                    queue.add(new Node(ny, nx));
                }
            }
        }
        
        return count;
    }
    
    public boolean isValid(int y, int x, int m, int n) {
        return 0 <= y && y < m && 0 <= x && x < n;
    }
    
}

class Node{
    int y;
    int x;
    
    public Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}