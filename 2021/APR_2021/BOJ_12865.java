import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int num = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]);
        int[] weight = new int[num];
        int[] value = new int[num];
        int[][] dp = new int[num+1][k+1];

        // 입력받은 무게와 가치를 각각 배열에 저장
        for (int i = 0; i < num; i++) {
            st = br.readLine().split(" ");
            weight[i] = Integer.parseInt(st[0]);
            value[i] = Integer.parseInt(st[1]);
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= k; j++) {
                // i번째 weight를 w에 저장
                int w = weight[i-1];
                // i번째 value를 v에 저장
                int v = value[i-1];

                dp[i][j] = dp[i-1][j];

                // 현재 무게에 다른 무게를 더해도 되면
                if (j >= w) {
                    // 이전 값과 남은 무게의 가치 + 현재 가치와 현재 값 중 큰 값을 고른다.
                    dp[i][j] = Math.max(dp[i-1][j-w] + v, dp[i][j]);
                }
            }
        }

        System.out.println(dp[num][k]);

    }
}