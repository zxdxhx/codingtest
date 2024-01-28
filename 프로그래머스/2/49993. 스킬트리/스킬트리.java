import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        
        for(int i = 0; i < skill_trees.length; i++){
            String target_str = skill_trees[i];
            String skill2 = skill;
            boolean flag = true;
            for(int j = 0; j < target_str.length(); j++){
                char c = target_str.charAt(j);
                
                if(skill.contains(String.valueOf(c))){
                    //포함되어있으면 제일 첫번째꺼여야함
                    if(c != skill2.charAt(0)){
                        flag = false;
                        break;
                    }else{
                        skill2 = skill2.substring(1);
                    }
                }
            }
            if(flag) answer++;
            
        }
        
        
        return answer;
    }
}