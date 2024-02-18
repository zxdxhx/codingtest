import java.util.*;
class Solution {
    static ArrayList<String> arrlist;
    static boolean[] visit;
    
    static void dfs(String[][] tickets, int depth, String path, String start){
        if(depth == tickets.length){   //티켓을 다썼으면
            arrlist.add(path);
            return;
        }
        for(int i = 0; i< tickets.length; i++){
            if(!tickets[i][0].equals(start)) continue;
            if(visit[i])continue;

            visit[i] = true;
            dfs(tickets, depth+1, path+" "+tickets[i][1], tickets[i][1]);
            visit[i] = false;
        }
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer ;
        
        arrlist = new ArrayList<String>();
        visit = new boolean[tickets.length];
        
        dfs(tickets, 0, "ICN","ICN");
        
        Collections.sort(arrlist);
        //System.out.print(arrlist.get(0));
        answer  = arrlist.get(0).split(" ");
        
        return answer;
    }
}