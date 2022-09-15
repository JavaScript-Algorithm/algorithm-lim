class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int num = arr[arr.length - 1];
        int count = 1;
        while(true) {
            int temp = num * count;
            int i = 0;
            for(i = 0; i < arr.length; i++) {
                if(temp % arr[i] != 0){       
                    break;  
                }
            }
            
            if(i == arr.length){
                answer = temp;
                break;
            }
            count++;
        }
        
        
        return answer;
    }
}