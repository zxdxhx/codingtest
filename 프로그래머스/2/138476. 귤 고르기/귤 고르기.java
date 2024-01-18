import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        int[] count = new int[tangerine.length];
        int cnt = 1;
        int index = 0;
        
        for(int i = 1; i <= tangerine.length; i++){
            if(i == tangerine.length){  //마지막애 비교할때
                count[index++] = cnt;
                break;
            }
            if(tangerine[i]==tangerine[i-1]){
                cnt++;
            }else{
                count[index++] = cnt;
                cnt = 1;
            }
        }
        Arrays.sort(count);
        
        for(int i = count.length-1; i >= 0; i--){
            if(k > count[i]){
                answer++; 
                k -= count[i];
            }else if(k <= count[i]){
                answer++;
                break;
            }
        }
        return answer;
    }
}