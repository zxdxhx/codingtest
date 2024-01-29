import java.util.*;
class Solution {
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};
    static int[][] dist;
    static boolean[][] visit;
    
    static int[] findkey(int x){
        int[] loc = new int[2];
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == x){
                    loc[0] = i;
                    loc[1] = j;
                    return loc;
                }
            }
        }
        return loc;
    }
    
    static int find(int currx, int curry, int tgx, int tgy){
        Queue<Integer> que = new LinkedList<>();
        visit =  new boolean[arr.length][arr[0].length];
        dist =  new int[arr.length][arr[0].length];
        
        que.add(currx);
        que.add(curry);
        visit[currx][curry] = true;
        dist[currx][curry] = 1;
        int distance = 0;
        
        while(!que.isEmpty()){
            int x = que.poll(); //0
            int y = que.poll(); //3
            
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if(nx < 0 || ny < 0 || nx > arr.length - 1 || ny > arr[0].length - 1) continue;
                if(visit[nx][ny]) continue;
                if(arr[nx][ny] == -1  || arr[nx][ny] == -2 ) continue; // * || #
    
                que.add(nx);
                que.add(ny);
                
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                
                if(nx == tgx && ny == tgy) break;
            }
            
        }
        
        return dist[tgx][tgy];
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int bfrLeftHand = -1;
        int bfrRightHand = -2;
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0){
                //오른쪽 좌표
                int[] right = findkey(bfrRightHand);
                //왼쪽 좌표
                int[] left = findkey(bfrLeftHand);
                //타겟좌표
                int[] target = findkey(numbers[i]);
                
                int fromRight = find(right[0], right[1], target[0], target[1]); 
                int fromLeft = find(left[0], left[1], target[0], target[1]);
                
                if(fromRight>fromLeft) {
                    answer += "L";
                    bfrLeftHand = numbers[i];
                }else if(fromRight<fromLeft){
                    answer +="R";
                     bfrRightHand = numbers[i];
                } else{   // 거리가 같으면
                    if(hand.equals("right")){
                        answer +="R";
                        bfrRightHand = numbers[i];
                    } else{
                        answer += "L";
                        bfrLeftHand = numbers[i];
                    }
                }
                
            }else{
                if(numbers[i] == 1|| numbers[i] == 4|| numbers[i] == 7){
                    answer += "L";
                    bfrLeftHand = numbers[i];
                }else{
                    answer += "R";
                    bfrRightHand = numbers[i];
                }
            }
        }
        
        return answer;
    }
}