import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] arr = new int[101][101];
        int num = scan.nextInt();
        int answer = 0;
        for(int i = 0; i < num; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            for(int a = x; a < x+10; a++){
                for(int b = y; b < y+10; b++){
                    if(arr[a][b] == 0) {
                        arr[a][b] = 1;
                        answer ++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
