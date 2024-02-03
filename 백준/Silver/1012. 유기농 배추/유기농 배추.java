import java.util.*;

public class Main {static char[] candi;
    static int[][] map ;
    static boolean[][] visit;
    static int M, N , K;
    static int bug;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(visit[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            dfs(nx,ny);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();

        for(int i = 0; i < testcase; i++){
            M = scan.nextInt();
            N = scan.nextInt();
            K = scan.nextInt();

            map = new int[M][N];
            visit = new boolean[M][N];
            bug = 0;
            for(int j = 0; j < K; j++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                map[x][y] = 1;
            }

            for(int x = 0; x < M; x++){
                for(int y = 0; y < N; y++){
                    if(map[x][y] == 1 && !visit[x][y]) {
                        dfs(x,y);
                        bug++;
                    }
                }
            }

            System.out.println(bug);
        }
    }
}
