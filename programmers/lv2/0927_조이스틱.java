class Solution {
    public int solution(String name) {
        int answer = 0;
        int leng = name.length();
        
        int min = leng - 1;
        
        for(int i = 0; i < leng; i++){
            char c = name.charAt(i);
            answer += (c - 'A' < 'Z' - c + 1)? (c - 'A') : ('Z' - c + 1);
            
            int nextIndex = i + 1;
            
            while(nextIndex < leng && name.charAt(nextIndex) == 'A'){
                nextIndex++;
            }
            
            min = Math.min(min, i * 2 + (leng - nextIndex));
            min = Math.min(min, i + (leng - nextIndex) * 2);
            
        }
        
        answer += min;
        
        return answer;
    }
}