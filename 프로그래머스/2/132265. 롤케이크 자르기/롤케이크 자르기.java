import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> ob = new HashMap<>();
        Map<Integer, Integer> yb = new HashMap<>();
        
        //우선 형한테 다담아
        for(int x : topping){   
            ob.put(x, ob.getOrDefault(x,0)+1);
        }
        
        //동생한테 담으면서 갯수 비교
        //두개가 같아지는 순간이 오면 동일하게 나눠가진거
        for(int i = 0; i< topping.length; i++){
            yb.put(topping[i], yb.getOrDefault(topping[i],0)+1);
            
            if(ob.get(topping[i]) -1 == 0){
                ob.remove(topping[i]);
            }else{
                ob.put(topping[i], ob.get(topping[i])-1);
            }
            
            if(ob.size() == yb.size()){
                answer++;
            }
        }
        
        return answer;
    }
}