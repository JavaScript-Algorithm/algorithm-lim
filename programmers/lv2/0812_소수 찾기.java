import java.util.*;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    public static boolean[] check;
    public static int answer;
    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        String temp = "";
        for(int i = 1; i <= numbers.length(); i++){
            dfs(numbers, temp, i);
        }
        
        for(int num : set){
            is_prime(num);
        }
        
        return answer;
    }
    
    public void dfs(String str, String tmp, int m){        
        if(tmp.length() == m){            
            int num = Integer.parseInt(tmp);            
            set.add(num);            
            return;        
        }else{            
            for(int i=0;i<str.length();i++){                
                if(!check[i]){                    
                    check[i] = true;                    
                    tmp += str.charAt(i);                   
                    dfs(str, tmp, m);                    
                    check[i] = false;                   
                    tmp = tmp.substring(0, tmp.length()-1);               
                }            
            }       
        }                       
    }
    
    public void is_prime(int n){        
        if(n==0) return;        
        if(n==1) return;        
        for(int i=2;i< n ;i++){            
            if(n % i == 0) return;        
        }        
        answer++;    
    }

}