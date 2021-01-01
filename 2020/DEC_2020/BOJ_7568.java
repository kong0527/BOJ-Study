import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[][] = new int[num][2];
		
		for (int i = 0; i < num; i++) {
			String st[] = br.readLine().split(" ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
				
		solve(num, arr);
	}

	public static void solve(int num, int arr[][]) {
		int ans[] = new int[num];
		
		for (int i = 0; i < num; i++) {
			int count = 0;
			for (int j = 0; j < num; j++ ) {
				if (i == j) {
					continue;
				}
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					count++;
				}
			}
			ans[i] = count + 1;
		}
		
		
		for (int n : ans) {
			System.out.println(n);
		}
	}
}
