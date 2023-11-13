import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        //ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < elements.length; i++){   //첫번째원소부터 확인
            for(int j = 1; j <= elements.length; j++){  //부분집합 가능한 수
                int sum = 0;
                for(int z = i; z < i+j; z++){ 
                    if(z >= elements.length){
                        sum += elements[z-elements.length];
                    }else{
                        sum += elements[z];
                    }
                }
                if(!set.contains(sum)){
                    set.add(sum);
                    answer++;
                }
            }
        }
       
        return answer;
    }
}