import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int arr[] = new int[Integer.parseInt(s[0])];
		int num = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		System.out.println(solve(arr, num));
	}
	
	public static int solve(int arr[], int num) {
		int max = 0;
		
		for (int i = 0; i < arr.length-2; i++) {
			for (int j = i+1; j < arr.length-1; j++) {
				for (int k = j+1; k < arr.length; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum <= num) {
						max = Math.max(max, sum);
					}
				}
				if (max == num) {
					break;
				}
			}
		}
		
		
		return max;
	}

}
