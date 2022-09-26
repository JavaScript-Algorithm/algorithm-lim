class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;
        int max = 1;
        
        boolean check = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1){
                    check = true;
                    break;
                }
            }
        }
        
        if(!check){
            return 0;
        }
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                if(board[i][j] == 0) {
                    continue;
                }
                
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                
                if(board[i][j] > max) {
                    max = board[i][j];
                }
            }
        }
        
        answer = max * max;
        
        return answer;
    }
}