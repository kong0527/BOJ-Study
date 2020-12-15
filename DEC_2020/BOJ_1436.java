import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(solve(num));
	}
	
	public static int solve(int num) {
		int count = 0;
		for (int i = 666; ; i++) {
			if (count == num) {
				return --i;
			}
			if (String.valueOf(i).contains("666")) {
				count++;
			}
		}
	}
}
