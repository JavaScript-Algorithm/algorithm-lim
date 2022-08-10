import java.util.*;

class Solution {
    public static long MAX = 0;
    public static List<Long> numList = new ArrayList<>();
    public static List<Character> optList = new ArrayList<>();
    public static List<Character> optKind;
    public static boolean[] visit;
    
    public long solution(String expression) {
        splitData(expression);
        visit = new boolean[optKind.size()];
        List<Character> order = new ArrayList<>();
        permutation(order);
        
        return MAX;
    }
    
    public void splitData(String str) {
        char[] arr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i]== '+' || arr[i] == '-' || arr[i] == '*'){
                set.add(arr[i]);
                optList.add(arr[i]);
                numList.add(Long.parseLong(sb.toString()));
                sb = new StringBuffer();
            }else{
                sb.append(arr[i]);
            }
        }
        
        numList.add(Long.parseLong(sb.toString()));
        optKind = new ArrayList<>(set);
    }
    
    public void permutation(List<Character> order) {
        if(order.size() == optKind.size()){
            long result = getMax(order);
            if(result > MAX) {
                MAX = result; 
            }
            return;
        }
        
        for(int i = 0; i < optKind.size(); i++){
            if(!visit[i]) {
                visit[i] = true;
                order.add(optKind.get(i));
                permutation(order);
                visit[i] = false;
                order.remove(order.size() - 1);
            }
        }
    }
    
    public long getMax(List<Character> order) {
        List<Long> copyNum = new ArrayList(numList);
        List<Character> copyOpt = new ArrayList(optList);
        
        for(char opt : order){
            for(int i = 0; i < copyOpt.size(); i++){
                if(opt == copyOpt.get(i)){
                    copyNum.set(i, cale(opt, copyNum.get(i), copyNum.get(i + 1)));
                    copyNum.remove(i + 1);
                    copyOpt.remove(i);
                    i--;
                }
            }
        }
        return Math.abs(copyNum.get(0));
    }
    
    public long cale(char opt, long num1, long num2){
        long result = 0;
        if(opt == '+'){
            result = (num1 + num2);
        }else if(opt == '-'){
            result = (num1 - num2);
        }else{
            result = (num1 * num2);
        }
        
        return result;
    }
}