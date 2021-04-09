import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] dp = new int[num + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= num; i++) {
            // i번째 줄에 아무것도 배치되지 않은 경우
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            // i번째 줄 왼쪽에 사자가 배치된 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            // i번째 줄 오른쪽에 사자가 배치된 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        // num번째 줄의 dp 값들을 모두 더한 것이 답
        int ans = (dp[num][0] + dp[num][1] + dp[num][2]) % 9901;
        System.out.println(ans);
    }
}