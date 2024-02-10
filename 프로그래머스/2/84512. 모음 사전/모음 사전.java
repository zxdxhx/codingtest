import java.util.*;
class Solution {
    static List<String> elements;
    static String[] vowel = {"A", "E", "I", "O", "U"};
    static void rec(int depth, String ans){
        if(!elements.contains(ans)){
            elements.add(ans);
        }
        
        if(depth == 5){
            return ;
        }else{
            for(int i = 0; i< vowel.length; i++){
                rec( depth+1, ans+vowel[i]);
            }
        }
    }
    public int solution(String word) {
        int answer = 0;
        elements = new ArrayList<>();
        
        String ans = "";
        
        rec(0, ans);
        
        
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).equals(word)){
                break;
            }
            answer++;
        }
        
        return answer;
    }
}