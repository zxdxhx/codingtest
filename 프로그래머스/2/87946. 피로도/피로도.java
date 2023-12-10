import java.util.*;
class Solution {
    static boolean[] visit; 
    static int currPoint;
    static int maxCnt;
    static int answer; 
    public void fun(int depth, int k, int[][] dungeons){
        // 던전을 다 못돌수도 있으니까 depth로 조건을 걸면 안됐음; 
        for(int i = 0; i < dungeons.length; i++){
            if(visit[i]) continue;
            if(k < dungeons[i][0] || k < dungeons[i][1]) continue;
                
            visit[i] = true;
            fun(depth + 1, k - dungeons[i][1], dungeons);
            visit[i] = false;
        }
        answer = Math.max(answer, depth);
    }
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        
        answer = 0;
        fun(0, k, dungeons);
        
        return answer;
    }
}