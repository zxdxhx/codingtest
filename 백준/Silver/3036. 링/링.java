import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int num1 = scan.nextInt(); //기준이 되는 애
        int num2 = 0;
        int max = 0;
        String str = "";
        for(int i = 0; i< n-1; i++){
            num2 = scan.nextInt();
            max = 0;
            for(int j = 1; j <= Math.min(num1, num2); j++){
                if(num1 % j==0 && num2 % j == 0){
                    max = j;
                }
            }
            int ans1 = num1/max;
            int ans2 = num2/max;

           str += ans1+"/"+ans2 + "\n";
        }

        System.out.print(str);

    }
}
