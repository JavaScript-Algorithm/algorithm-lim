class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String numbers = Integer.toString(n, k);
        
        for(int i = 0; i < numbers.length(); i++){
            if(numbers.charAt(i) != '0'){
                for(int j = i + 1; j <= numbers.length(); j++) {
                    if(j == numbers.length() || numbers.charAt(j) == '0'){
                        long num = Long.parseLong(numbers.substring(i, j));
                        
                        boolean check = true;
                        
                        if(num == 1){
                            check = false;
                        }else {
                            for(long s = 2; s <= Math.sqrt(num); s++){
                                if(num % s == 0) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        
                        if(check){
                         answer++;   
                        }
                        
                        i = j;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}