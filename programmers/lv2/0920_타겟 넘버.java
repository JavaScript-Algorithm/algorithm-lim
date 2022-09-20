class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int num, int target) {
        if(depth == numbers.length) {
            if(num == target){
                answer++;
            }
            return;
        }
        
        for(int i = 0; i < 2; i++){
            if(i == 0) {
                num += numbers[depth];
            }else{
                num -= numbers[depth];
            }
            
            dfs(numbers, depth + 1, num, target);
            
            if(i == 0) {
                num -= numbers[depth];
            }else{
                num += numbers[depth];
            }
        }
        
    }
}