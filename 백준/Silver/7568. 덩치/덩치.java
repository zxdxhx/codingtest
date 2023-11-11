
import java.util.*;
public class Main {
    static int N;
    static int[] rank;
    static People[] people;

    static class People{
        int weight;
        int height;
        People(int w, int h){
            this.weight = w;
            this.height = h;
        }
    }

    static void compare(int index){
        int count = 1;
        for(int i = 0; i<N;i++){
            if(index == i) continue;

            if(people[index].weight<people[i].weight &&people[index].height<people[i].height)
                count ++;
        }
        rank[index] = count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        rank = new int[N];
        people = new People[N];

        for(int i =0; i<N; i++){
            int w = scan.nextInt();
            int h = scan.nextInt();
            people[i] = new People(w,h);
        }

        for(int i  = 0; i<N; i++){
            compare(i);
            System.out.print(rank[i]+" ");
        }

    }
}
