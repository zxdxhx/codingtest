import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arr = new int[1001];
        int input = scan.nextInt();

        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= input; i++ ) {
            arr[i] =( arr[i - 2] + arr[i - 1] )%10007;
        }
        System.out.print(arr[input]);
    }
}
