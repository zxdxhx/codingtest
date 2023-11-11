import java.util.*;
public class Main {
    static class People{
        int w;
        int h;
        People(int w, int h){
            this.w = w;
            this.h = h;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] rank = new int[num];
        People[] people = new People[num];

        for(int i  = 0; i< num; i++) {
            int w = scan.nextInt();
            int h = scan.nextInt();
            people[i] = new People(w, h);
        }
        for(int i = 0; i< num; i++){
            int count = 0;
            for(int j = 0; j < num; j++){
                People target = new People(people[i].w, people[i].h);
                if(i == j) continue;
                if(target.w < people[j].w){
                    if(target.h < people[j].h){
                        count++;
                    }
                }
            }
            rank[i] = count + 1;
        }
        for(int i = 0; i < num; i++){
            System.out.print(rank[i] + " ");
        }
    }
}
