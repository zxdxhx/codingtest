class Solution {
    public String solution(int[] food) {
        String answer = "";
        int food_count = 0;
        for(int i = 1 ; i < food.length; i++){
            if(food[i]%2 == 1){
                food[i] = food[i] - 1;
            }
            food_count += food[i];
        }
        // for(int i = 0; i< food.length; i++){
        //     System.out.print(food[i] + " ");
        // }
        int start = 0;
        int end = food_count;
        int[] ans = new int[food_count+1];
        
        for(int i = 1; i< food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                ans[start++] = i;
                ans[end--] = i;
            }
        }
        ans[food_count/2] = 0;
        
        for(int i = 0; i < food_count+1; i++){
            answer+=ans[i];
        }
        return answer;
    }
}