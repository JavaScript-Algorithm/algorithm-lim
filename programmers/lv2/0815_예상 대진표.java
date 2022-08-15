class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = n/2;
        boolean big = a > b ? true : false;
    
       for(int i = 1; i < n/2; i++){
           if(isCheck(big, a, b)){
               answer = i;
               break;
           }
            if(a % 2 == 1){
                a = (a + 1) / 2;
            }else{
                a /= 2;
            }
            
            if(b % 2 == 1){
                b = (b + 1) / 2;
            }else{
                b /= 2;
            }
       }

        return answer;
    }
    
    public boolean isCheck(boolean big, int a, int b) {
        if(big){
            if(a - b == 1 && a % 2 == 0 && b % 2 == 1){
                return true;
            }
        }else{
            if(b - a == 1 && a % 2 == 1 && b % 2 == 0){
                return true;
            }
        }
        
        return false;
    }
}