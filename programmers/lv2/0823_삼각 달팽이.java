class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] map = new int[n][n];
        int num = 1;
        int y = -1;
        int x = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){
                    y++;
                }else if(i % 3 == 1){
                    x++;
                }else if(i % 3 == 2) {
                    y--;
                    x--;
                }
                
                map[y][x] = num++;
            }    
        }
        
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0) break;
                answer[index++] = map[i][j];
            }
        }
        
        return answer;
    }
}