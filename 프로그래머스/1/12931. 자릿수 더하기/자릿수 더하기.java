import java.util.*;
public class Solution {
    public int solution(int n) {
        int answer = 0;
        String numstr = Integer.toString(n);
        
        for (int i = 0; i<numstr.length(); i++) {
            answer += numstr.charAt (i) - '0' ;
        }
        
        return answer;
    }
}