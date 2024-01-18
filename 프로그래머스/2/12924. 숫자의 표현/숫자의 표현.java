class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sum = 0;
        
        for(int start = 1; start <= n; start++){
            sum = 0;
            for(int i = start; i <= n; i++){
                sum += i;
                if(sum == n) {
                    answer++;
                    break;
                }else if(sum > n){
                    break;
                }
            }
        }
        return answer;
    }
}