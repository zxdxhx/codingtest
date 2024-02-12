import java.util.*;
class Solution {
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visit;
    static int[][] dist;
    static int n,m;
    static void bfs(int[][] maps, int x, int y){
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        visit[x][y] = true;
        dist[x][y] = 1;
        
        while(!que.isEmpty()){
            int xx = que.poll();
            int yy = que.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = xx + dir[i][0];
                int ny = yy + dir[i][1];
                
                if(nx < 0 || ny < 0 || nx > n || ny > m) continue;
                if(visit[nx][ny])continue;
                if(maps[nx][ny] == 0) continue;
                
                visit[nx][ny] = true;
                dist[nx][ny] = dist[xx][yy] + 1;
                que.add(nx);
                que.add(ny);
            }
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        
        visit = new boolean[maps.length][maps[0].length];
        dist = new int[maps.length][maps[0].length];
        
        n = maps.length -1;
        m = maps[0].length -1;

        bfs(maps, 0,0);
        if(dist[n][m] == 0){
            answer = -1;
        }else{
            answer = dist[n][m];
        }
        
//         if(maps[n-1][m] == 0 && maps[n][m-1] == 0){
//             answer = -1;
//         }else{
           
//         }

        return answer;
    }
}