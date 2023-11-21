import java.util.*;
public class Main {
    static boolean[] visit;
    static int[] arr;
    static ArrayList<Integer>[] adj;
    static int count;
    static void dfs(int start) {
        visit[start] = true;

        for (int a : adj[start]) {
            if (visit[a]) continue;
            count++;
            dfs(a);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner (System. in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        adj = new ArrayList [N+1] ;
        visit = new boolean[N+1];
        Arrays.fill(visit, false);

        for(int i = 0; i< N+1; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj[a].add(b) ;
            adj[b].add(a) ;
        }
        for(int i = 0; i<N +1; i++){
            Collections.sort(adj[i]);
        }
        count=0;
        dfs(1);
        System.out.println(count);
    }
}
