import java.util.*;
class Solution {
    int[][]  dir = {{1,0},{-1,0},{0,-1},{0,1}};
    boolean[][] visit; 
    int[][] map;
    int food;
    public void dfs(int x, int y){
        visit[x][y] = true;
        food += map[x][y];
        
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            
            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
            if(map[nx][ny] == -1) continue;
            if(visit[nx][ny]) continue;
        
            visit[nx][ny] = true;
            dfs(nx, ny);
        }
    }
    public int[] solution(String[] maps) {
        visit = new boolean[maps.length][maps[0].length()];
        map = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) == 'X')
                    map[i][j] = -1;
                else{
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(!visit[i][j] && map[i][j] != -1){
                    food = 0;
                    dfs(i,j);
                    ans.add(food);
                }
            }
        }
        Collections.sort(ans);
        
        int[] answer;
        if(ans.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[ans.size()];
            for(int i = 0; i<ans.size(); i++){
                answer[i] = ans.get(i);
            }
        }
        return answer;
    }
}