class Solution {
    public int[] solution(long begin, long end) {
        int intBegin = (int)begin;
        int intEnd = (int)end;
        
        int[] answer = new int[(intEnd - intBegin) + 1];
        int index = 0;
        
        for(int i = intBegin; i <= intEnd; i++){
            boolean flag = false;
            
            if(i == 1) {
                answer[index++] = 0;
                continue;
            }
            
            for(int j = 2; j * j <= i; j++){
                    if(i % j == 0 && i / j <= 10000000){
                        answer[index++] = i / j;
                        flag = true;
                        break;
                    }
            }
            
            
            if(!flag) {
                answer[index++] = 1;
            }
            
        }
        
        return answer;
    }
}