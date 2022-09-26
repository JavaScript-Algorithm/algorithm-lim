class Solution {
    static int[][] answer;
    static int index = 0;
    public int[][] solution(int n) {
        answer = new int[(int) (Math.pow(2, n) - 1)][2];
        
        hanoi(n, 1, 2, 3);
        
        return answer;
    }
    
    public void hanoi(int n, int start, int mid, int to) {
        if(n == 1){
            answer[index][0] = start;
            answer[index][1] = to;
            return;
        }
        
        hanoi(n - 1, start, to, mid);
        index++;
        
        answer[index][0] = start;
        answer[index][1] = to;
        index++;
        
        hanoi(n - 1, mid, start, to);
    }
}