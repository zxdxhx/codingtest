
import java.util.*;
public class Main {
    static int N, max, min;
    static int[] nums, operators;


    static int calculator(int operand1, int operator, int operand2){
        // value, order[i], num[i+1]
        if (operator == 1) // +
            return operand1 + operand2;
        else if (operator == 2) // -
            return operand1 - operand2;
        else if (operator == 3) // *
            return operand1 * operand2;
        else //
            return operand1 / operand2;
    }


    static void rec_func(int k, int value){// 현재 연산자 골라진것
        //만약 다 골라졌으면 min, max 비교해야해
        if(k==N){
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        //안골라졌으면 함수재호출해서 고르기
        else{ //k번째 연산자고르기
            for(int candi = 1; candi<=4; candi++){
                if(operators[candi]>=1){
                    operators[candi]--;
                    rec_func(k+1, calculator(value,candi,nums[k+1]));
                    operators[candi]++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
    }
}