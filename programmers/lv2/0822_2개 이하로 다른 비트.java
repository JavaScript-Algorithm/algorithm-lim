class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            answer[i] = check(numbers[i]);
        }
        
        return answer;
    }
    
    public long check(long num) {
        if(num % 2 == 0){
            return num + 1;
        }else {
            StringBuffer sb = new StringBuffer();
            String binaryNum = Long.toBinaryString(num);
            if(!binaryNum.contains("0")){
                sb.append("10");
                sb.append(binaryNum.substring(1).replace("0", "1"));
            }else{
                int lastIndex = binaryNum.lastIndexOf("0");
                int firstOneIndex = binaryNum.indexOf("1", lastIndex);
                
                sb.append(binaryNum, 0, lastIndex).append("1");
                sb.append("0");
                sb.append(binaryNum.substring(firstOneIndex + 1));
            }
            return Long.parseLong(sb.toString(), 2);
        }
    }
}