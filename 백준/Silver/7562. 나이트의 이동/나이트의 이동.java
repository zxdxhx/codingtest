
import java.util.*;

public class Main {
    static int N;
    static int[][] dist;
    static int[][] dir = {{-2,-1},{-1,-2},{1,-2},{2,-1},{-2,1},{-1,2},{1,2},{2,1}};

    static void bfs(int x, int y){
        for(int[] d : dist){
            Arrays.fill(d,-1);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        dist[x][y] = 0;

        while(!que.isEmpty()){
            x = que.poll();
            y = que.poll();

            for(int i =0; i<8; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 0 || ny < 0 || nx>=N || ny>=N) continue;
                if(dist[nx][ny] != -1) continue;

                que.add(nx); que.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int testcase = scan.nextInt();
        while(testcase -- > 0){
            N = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int tx = scan.nextInt();
            int ty = scan.nextInt();
            dist = new int[N][N];
            bfs(x, y);
            System.out.println(dist[tx][ty]);
        }
    }

}
