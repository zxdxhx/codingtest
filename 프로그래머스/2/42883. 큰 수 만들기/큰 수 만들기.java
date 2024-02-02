import java.util.*;
class Solution {
    public String solution(String number, int k) { 
        String answer = "";
        int selectIndex = -1;
        int maxNum = 0;
        for(int i = 0; i<number.length(); i++){
            if(maxNum < (number.charAt(i)-'0'))
               maxNum = number.charAt(i)-'0';
        }

               
        for(int i =  k; i < number.length(); i++){  //뒤에 남겨놔야하는 개수
            int max = 0;
            int currmax = 0;
            int maxIndex = -1;
            for(int j = selectIndex + 1; j <= i; j++){  //max값 찾아야하는 index
                if((number.charAt(j) -'0') == maxNum){
                    currmax = (number.charAt(j) -'0');
                    maxIndex = j;
                    break;
                }else{
                    if(currmax < (number.charAt(j) -'0')){
                        currmax = (number.charAt(j) -'0');
                        maxIndex = j;
                    }
                }
            }
            if(max < currmax ){
                selectIndex = maxIndex;
                max = currmax;
            }
            answer += String.valueOf(max);
        }
        return answer;
    }
    //재귀로 풀었더니 런타임에러+시간초과남 ,,
//     static char[] candi;
//     static char[] selected;
//     static boolean[] used;
//     static int max;
//     static void rec(int a, int index){
//         if(a == selected.length){
//             String sum = "";
//             for(int i = 0; i < selected.length; i++){
//                 sum += selected[i];
//             }
//             max = Math.max(Integer.valueOf(sum),max);

//         }else{
//             for(int i = index+1; i < candi.length; i++){
//                 if(used[i]) continue;
//                 selected[a] = candi[i]; //한개씩 채워보기
//                 used[i] = true;

//                 rec(a+1,i);
//                 used[i] = false;
//                 selected[a] = '-';
//             }
//         }
//     }
//     public String solution(String number, int k) {        
//         candi = new char[number.length()];
//         used = new boolean[number.length()];
//         selected = new char[number.length()-k];
//         max = 0;
        
//         for(int i = 0; i < number.length(); i++){
//             candi[i] = number.charAt(i);
//             //number를 int형으로 변환하여 배열에 담음, 후보로 쓸 예정
//         }
        
//         rec(0,-1); // 재귀사용시 런타임에러 시간초과......
//         int selectIndex = -1;
//         int selectCount = numbers.length() - k;
        
//         for(int i  = selectCount - 1; i > 0 ; i--){ 
//             int max = 0; 
//             for(int j = ; j < ; j++){
//                 int curr = Integer.valueOf(numbers.charAt(j));
//             }
            
//         }
        
//         return String.valueOf(max);
//     }
}