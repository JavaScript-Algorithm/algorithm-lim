class Solution {
    public int solution(String word) {
//         int answer = word.length();
//         String str = "AEIOU";
//         int[] increase = {781, 156, 31, 6, 1};
        
//         for(int i = 0; i < word.length(); i++) {
//             int index = str.indexOf(word.charAt(i));
//             answer += increase[i] * index;
//         }
        
        int answer = 0;
        
        int per = 3905;
        
        for(String s: word.split("")) {
            answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        }
        
        return answer;
    }
}