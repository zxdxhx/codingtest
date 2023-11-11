import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int[] count = new int[tangerine.length];
        Arrays.sort(tangerine);
        
        int countnum = 1;
        int index = 0;
        
        for(int i = 1; i< tangerine.length+1; i++){
            if(i < tangerine.length && tangerine[i-1] == tangerine[i]){
                countnum++;
            }else{
                count[index++] = countnum;
                countnum = 1;
            }
        }
        
        Arrays.sort(count);
        
        int sum = 0;
        int answer = 0;
        for(int i = count.length - 1; i > -1; i--){
            if(sum >= k){
                 break;
            } else {
                sum += count[i];
                answer++;
            }
        }
        return answer;
    }
}