class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String bi = Integer.toBinaryString(n);
        int count = 0;
        
        for(int i = 0; i < bi.length(); i++) {
            if(bi.charAt(i) == '1'){
                count++;
            }
        }
        
        int num = n + 1;
        
        while(true){
            String bi2 = Integer.toBinaryString(num);
            
            int count2 = 0;
            
            for(int i = 0; i < bi2.length(); i++) {
                if(bi2.charAt(i) == '1'){
                    count2++;
                }                                               
            }
            
            if(count2 == count){
                break;
            }else{
                num++;
            }
            
        }
        
        answer = num;
        
        return answer;
    }
}