import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        
        for(int i = 0; i < people.length; i++){
            if(start == end){
                answer++;
                break;
            }else if(start > end){
                break;
            }
            if(people[start]+people[end] <= limit){
                start++;
                end--;
                answer++;
            }else{
                end--;
                answer++;
            }
        }
        return answer;
    }
}