import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] turn = new int[n+1];
        ArrayList<String> arrlist = new ArrayList<String>();
        
        Arrays. fill (turn, 0);
                             
        int index = 2;
        int count = 1;
        arrlist.add(words[0]);
        turn [1] = 1;
        
                             
        for(int i = 1; i < words.length; i++){
            if (i%n == 0) { //턴 마다 index 초기화
                index = 1;
                count++;
            }
            if(arrlist.contains(words [i])){    //중복체크
                answer[0] = index;//번호 
                answer[1] = count;//차례 
                break;
            }else{
                arrlist.add(words[i]);
            }
            char bfr = words [i-1]. charAt (words [i-1]. length () -1) ;
            char curr = words [i]. charAt (0) ;
            if(bfr != curr) {   //앞뒤단어체크
                answer[0] = index;//번호 
                answer[1] = count;//차례 
                break;
            }
            turn [index++]++;
        }
        return answer;
    }
}