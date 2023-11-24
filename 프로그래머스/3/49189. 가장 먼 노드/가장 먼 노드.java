import java.util.*;
class Solution {
    ArrayList<Integer>[] arrList;
    boolean[] visit;
    int[] countArr;
    int count;
    int x;
    public void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;
        countArr[start] = 0;
        
        while(!que.isEmpty()){
            x = que.poll();
            for(int a: arrList[x]){
                if(visit[a]) continue;
                
                que.add(a);
                visit[a] = true;
                countArr[a] = countArr[x]+1;
            }
        }
        
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new boolean[n+1];
        Arrays.fill(visit, false);
        countArr = new int[n+1];
        arrList = new ArrayList[n+1];
        
        for(int i = 0; i < n+1; i++){
            arrList[i] = new ArrayList<Integer>();    
        }
        
        for(int[] arr : edge){
            arrList[arr[0]].add(arr[1]);
            arrList[arr[1]].add(arr[0]);
        }
        
        
        bfs(1);
        for(int i = 0; i< countArr.length; i++){
            if(countArr[x] == countArr[i])
                answer++;
        }
        return answer;
    }
}