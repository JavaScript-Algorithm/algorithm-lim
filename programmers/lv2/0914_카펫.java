class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 2; i <= sum / 2; i++){
            if(sum % i == 0){
                int temp = ((sum / i) * 2) + ((i - 2) * 2);
                if(temp == brown){
                    answer[0] = sum / i;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}