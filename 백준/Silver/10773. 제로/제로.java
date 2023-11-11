import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] answer= new int[num];
        Arrays.fill(answer, -1);
        int index  = 0;

        for(int i = 0; i< num; i++){
            int jh = scan.nextInt();
            if(jh != 0){
                answer[index++] = jh;
            }
            if(jh == 0){
                index--;
                for(int j = 1; j < num; j++){
                    if(answer[j] == -1){
                        answer[j-1] = -1;
                         break;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i< num; i++){
            if(answer[i] != -1) count += answer[i];
        }
        System.out.println(count);
    }
}
