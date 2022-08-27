import java.util.*;

public class Solution {
    public int solution(int n) {
        // int ans = 0;
        // while(n != 0) {
        //     if(n % 2 == 0) {
        //         n /= 2;
        //     } else {
        //         n -= 1;
        //         ans++;
        //     }
        // }
        // return ans;
        
        // 아 이건 주어진 N을 2진수로 바꾸면 나머지가 1인 경우는 1로 표시
        // 그리고 Integer클래스에서 주어진 정수 n의 2진수 값에 해당하는 1의 개수를 반환해주는 Integer.bitcCount()를 활용
        
        return Integer.bitCount(n);
    }
}