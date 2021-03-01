class Solution {
    public String solution(int n) {
        // 숫자 세 개를 3의 나머지로 표현
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        while (n > 0){
            // 나머지로 num을 판별하므로 변수에 저장하고, 다음 수를 판별하기 위해 3으로 나눠준다.
            int remainder = num % 3;
            n /= 3;

            // 3으로 나누어 떨어지는 수는 num - 1
            if(remainder == 0) {
                n--;
            }

            // 계산해서 나온 수를 앞에 붙여준다.
            answer = numbers[remainder] + answer;
        }

        return answer;
    }
}