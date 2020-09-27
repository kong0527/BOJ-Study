import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1138 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num+1];
		String st[] = br.readLine().split(" ");
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st[i-1]);
		}
		solve(arr);
	}
	
	public static void solve(int[] arr) {
		List<Integer> ans = new ArrayList<>();
		for (int i = arr.length-1; i > 0; i--) {
			ans.add(arr[i], i);
		}

		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

}
