import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		solve2(M, N);
	}
	
	// 에라토스테네스의 체
	public static void solve2 (int M, int N) {
		int arr[] = new int[N+1];
		Arrays.fill(arr, 0);
		arr[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; i * j <= N; j++) {
				arr[i * j] = 1;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (arr[i] != 1) {
				System.out.println(i);
			}
		}
		
	}
	
	// 전형적인 방식 -> 시간초과
	public static void solve (int M, int N) {
		int flag = 0;
		
		for (int i = M; i <= N; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = 1;
				}
			}
			if (flag == 1) {
				flag = 0;
			}
			else {
				System.out.println(i);
			}
		}
	}

}
