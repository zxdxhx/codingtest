import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        //a = 97, z = 122
        for(int i = 0; i < s.length(); i++){
            int numS = s.charAt(i); //숫자
            int count = 0;
            
             while(count < index){
                 numS ++;    //한칸 앞으로 
                 count++;
                if(numS > (int)'z'){
                    numS = (int)'a';    //다시 a부터 세기 시작
                }
                 char charS = (char)numS;
                for(int z = 0; z < skip.length(); z++){
                    if(charS == skip.charAt(z)){
                        count--;
                        break;
                    }
                }
             }
            answer += (char)numS;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}