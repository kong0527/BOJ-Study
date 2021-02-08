import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[num][3];

        for (int i = 0; i < num; i++) {
            String st[] = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(solve(arr));
    }

    public static int solve(int arr[][]) {
        int dp[][] = new int[arr.length][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][j];
                }

                else if (j == 1) {
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][j];
                }

                else {
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][j];
                }
            }
        }

        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
    }
}
