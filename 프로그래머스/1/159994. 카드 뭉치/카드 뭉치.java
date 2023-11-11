class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            if (!goal[i].equals (cards1 [count1]) && !goal[i].equals(cards2 [count2])) {
                answer = "No";
                break;
            }
            if (count1 < cards1.length-1 && goal[i].equals (cards1[count1])) count1++;
            else if (count2 < cards2.length-1 && goal[i].equals (cards2[count2])) count2++;     
        }
        return answer;
    }
}