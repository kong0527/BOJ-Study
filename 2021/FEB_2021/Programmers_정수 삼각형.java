class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        // 각 요소까 최댓값을 저장하기 위해 triangle과 크기가 같은 배열 생
        int dp[][] = new int[triangle.length][triangle.length];
        // dp 초기값 설정
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 맨 왼쪽의 경우 무조건 바로 위에서 오는 경우 뿐임
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                // 맨 오른쪽의 경우 왼쪽 대각선에서 오는 경우 뿐임
                else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                // 그 외의 경우 바로 위, 왼쪽 대각선에서 오는 경우를 따져봐야 함
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        // dp의 마지막 줄에서 최댓값 뽑아내는 과정
        for (int i = 0; i < dp.length; i++) {
            if (answer < dp[triangle.length-1][i]) {
                answer = dp[triangle.length-1][i];
            }
        }

        return answer;
    }
}