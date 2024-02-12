//국영수
/*
국어 내림
영어 오름
수학 감소
이름 사전순 증가
*/

import java.util.*;
public class Main {
    static class Elem implements Comparable<Elem>{
        String name;
        int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            if(korean != other.korean) return other.korean - korean;
            if(english != other.english) return english - other.english;
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }
    static int N;
    static Elem[] a;


    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        a = new Elem[N];
        for(int i = 0; i < N; i++){
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].korean = scan.nextInt();
            a[i].english = scan.nextInt();
            a[i].math = scan.nextInt();
        }

        Arrays.sort(a);
        for(int i =0; i<N; i++) System.out.println(a[i].name);
        System.out.println();
    }
}
