import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner (System. in);
        int N = scan.nextInt();
        int targetCount = scan.nextInt();

        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <=  N; i++){
            que.add(i);
        }
        int count = 0;
        String answer = "<";
        while(que.size()>1){
            int x = que.poll();
            count++;
            if(count == targetCount){
                count = 0;
                answer += x + ", ";
            }else{
                que.add(x);
            }
        }
        answer += que.poll() + ">";
        System.out.println(answer);

    }
}
