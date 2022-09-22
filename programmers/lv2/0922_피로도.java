class Solution {
    public int answer = 0;
    public int solution(int k, int[][] dungeons) {
        play(dungeons, new boolean[dungeons.length], k, 0);
        return answer;
    }
    
    
    public void play(int[][] dungeons, boolean[] visit, int k, int depth) {
        if(check(dungeons, visit, k)){
            answer = Math.max(answer, depth);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(dungeons[i][0] <= k && !visit[i]) {
                visit[i] = true;
                play(dungeons, visit, k - dungeons[i][1], depth + 1);
                visit[i] = false;
            }
        }
    }
    
    public boolean check(int[][] dungeons, boolean[] visit, int k) {
        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                return false;
            }
        }
        
        return true;
    }
}