import java.util.*;
public class Main {
    static int binary(int[] A,int L, int R, int x){
        while(L <= R){
            int mid = (L+R)/2;
            if(A[mid] == x) return 1;
            if(A[mid]<x){
                L = mid+1;
            }else{
                R = mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner (System. in);
        /* 이분탐색 */
        int N = scan.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = scan.nextInt();
        }
        Arrays.sort(A);

        int M = scan.nextInt();
        for(int i = 0; i <M; i++) {
            int x = scan.nextInt();

            System.out.println(binary(A,0, N - 1, x));
        }

        /*
        메모리초과 -->

        int N = scan.nextInt();
        Set<Integer> set= new HashSet<Integer>();
        for(int i = 0; i < N; i++){
            int x = scan.nextInt();
            set.add(x);
        }
        int M = scan.nextInt();
        String answer = "";
        for(int i = 0; i< M; i++){
            int x = scan.nextInt();
            if(set.contains(x)){
                answer += "1"+"\n";
            }else{
                answer += "0"+"\n";
            }
        }
        System.out.print(answer);
        */
    }
}
