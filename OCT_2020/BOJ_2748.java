import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());		
		System.out.println(solve(num));
	}
	
	public static long solve (int num) {
		long dp[] = new long[num+1];
		dp[0] = 0;	dp[1] = 1;
		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[num];
	}

}
