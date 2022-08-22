import java.util.*;

class Solution {
    public static char[][] map;
    public static boolean[][] visit;
    public static int answer = 0;
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            visit = new boolean[m][n];
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    if(map[i][j] >= 'A' && map[i][j] <= 'Z' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j + 1] && map[i][j] == map[i + 1][j]){
                        visit[i][j] = true;
                        visit[i + 1][j] = true;
                        visit[i][j + 1] = true;
                        visit[i + 1][j + 1] = true;
                        
                        inCheck(i + 1, j, m, n);
                        inCheck(i, j + 1, m, n);
                        inCheck(i + 1, j + 1, m, n);
                    }
                }
            }
            
            
            List<Character>[] lists = new ArrayList[n];
            int count = 0;
            for(int i = 0 ; i < n; i++){
                List<Character> list = new ArrayList<>();
                for(int j = m - 1; j >= 0; j--) {
                    if(!visit[j][i]){
                        list.add(map[j][i]);
                    }else{
                        count++;
                    }
                }
                lists[i] = list;
            }
            
            if(count < 4){
                break;
            }
            
            answer += count;
            
            map = new char[m][n];
            
            for(int i = 0; i < n; i++){
                for(int j = m - 1; j >= 0; j--){
                    if(lists[i].size() > 0){
                        map[j][i] = lists[i].get(0);
                        lists[i].remove(0);
                    }
                }
            }
        }
        
        return answer;
    }
    
    public void inCheck(int y, int x, int m, int n){
        if(y < m - 1 && x < n - 1) {
            if(map[y][x] >= 'A' && map[y][x] <= 'Z' && map[y][x] == map[y][x + 1] && map[y][x] == map[y + 1][x + 1] && map[y][x] == map[y + 1][x]){
                visit[y + 1][x] = true;
                visit[y][x + 1] = true;
                visit[y + 1][x + 1] = true;
            }
        }
    }
}