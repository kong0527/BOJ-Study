class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int add = (brown + 4) / 2;
        int multiple = brown + yellow;

        for (int i = 1; i <= add / 2; i++) {
            int tmp = add - i;
            if (tmp * i == multiple) {
                answer[0] = add - i;
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}