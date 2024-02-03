import java.util.*;

public class Main {static char[] candi;
    static boolean[] visit;
    static int[] time;
    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()){
            int curr = que.poll();
            int next ;

            if(curr + 1 < 100001 && !visit[curr+1]){
                next = curr + 1;
                que.add(next);
                visit[next] = true;
                time[next] = time[curr] + 1;
            }
            if(curr - 1 >= 0&& !visit[curr - 1]){
                next = curr - 1;
                visit[next] = true;
                que.add(next);
                time[next] = time[curr] + 1;
            }
            if(curr * 2 < 100001&& !visit[curr * 2]){
                next = curr * 2;
                que.add(next);
                visit[next] = true;
                time[next] = time[curr] + 1;
            }
        }

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();

        visit = new boolean[100001];
        time = new int[100001];

        Arrays.fill(time, 0);
        bfs(N);
        System.out.println(time[K]);
    }
}
