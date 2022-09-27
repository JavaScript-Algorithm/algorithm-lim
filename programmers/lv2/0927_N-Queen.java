class Solution {
    static public int[] check;
    static public int answer = 0;
    public int solution(int n) {
        check = new int[n];
        backTracking(n, 0);
        return answer;
    }
    
    
    public void backTracking(int n, int depth) {
        if(n == depth) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            check[depth] = i;
            if(possibliity(n, depth)) {
                backTracking(n, depth + 1);
            }
        }
    }
    
    public boolean possibliity(int n, int col) {
        for(int i = 0; i < col; i++){
            if(check[col] == check[i]) {
                return false;
            }else if(Math.abs(col - i) == Math.abs(check[col] - check[i])){
                return false;
            }
        }
        
        return true;
    }
}