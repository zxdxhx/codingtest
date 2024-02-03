import java.util.*;

public class Main {static char[] candi;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int sheep, wolf;
    static int R, C;
    static void dfs(int x, int y){
        if(map[x][y] == 'o') sheep++;
        if(map[x][y] == 'v') wolf++;

        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx >= R || ny >= C || nx < 0 || ny < 0) continue;
            if(visit[nx][ny]) continue;
            if(map[nx][ny] == '#') continue;

            dfs(nx, ny);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        R = scan.nextInt();
        C = scan.nextInt();
        scan.nextLine();

        map = new char[R][C];
        visit = new boolean[R][C];

        int totalWolf = 0;
        int totalSheep = 0;

        for(int i = 0; i < R; i++){
            String str = scan.next();
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] != '#' && !visit[i][j]){
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);
                    if(sheep <= wolf) {
                        totalWolf += wolf;
                    }else{
                        totalSheep += sheep;
                    }
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }
}
