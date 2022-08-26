class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int rmZero = 0;
        
        while(true){
            count++;
            String str = "";
            for(String word : s.split("")){
                if(word.equals("1")) {
                    str += "1";
                }else{
                    rmZero++;
                }
            }
            
            s = Integer.toBinaryString(str.length());
            
            if(s.equals("1")){
                break;
            }
        }
        
        answer[0] = count;
        answer[1] = rmZero;
        
        return answer;
    }
}