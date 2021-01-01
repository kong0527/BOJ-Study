import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(solve(num));
	}
	
	public static int solve(int num) {
		
		if (num % 5 == 0) {
			return num / 5;
		}
		
		else {
			int tmp = num / 5;
			for (int i = tmp; i > 0; i--) {
				int ans = i;
				if ((num - (i * 5)) % 3 == 0) {
					ans += (num - (i * 5)) / 3;
					return ans;
				}
			}
		}
		
		if (num % 3 == 0) {
			return num / 3;
		}
		
		return -1;
	}
}
