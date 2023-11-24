import java.util.*;
public class Main {
    //삽질 미치게 하다가 구글링 ㅠ
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        String[] arr = input.split("-");
        int answer = 0;

        for(String s : arr[0].split("[+]")){
            answer += Integer.valueOf(s);
        }   //처음 plus

        for(int i = 1; i<arr.length; i++){
            for(String s: arr[i].split("[+]")){
                answer -= Integer.valueOf(s);
            }
        }
        System.out.println(answer);
    }
}
