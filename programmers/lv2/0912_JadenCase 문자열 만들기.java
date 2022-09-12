class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer(); 
        int cursur = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != 32){
                sb.append(s.substring(cursur, i));
                
                int index = 0;
                for(int j = i + 1; j < s.length(); j++){
                    if(j == s.length() - 1){
                        index = j + 1;
                        break;
                    }
                    if(s.charAt(j) == 32){
                        index = j;
                        break;
                    }
                }
                
                sb.append(s.substring(i, i + 1).toUpperCase());
                if(index - i > 1){
                    sb.append(s.substring(i + 1, index).toLowerCase());
                }
                cursur = index;
                i = index;
            }else{
                if(i == s.length() - 1){
                    sb.append(s.substring(cursur, i + 1));
                }
            }
        }
        
        return sb.toString();
    }
}
