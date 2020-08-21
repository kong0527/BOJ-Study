import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		if (num == 1000) {
			System.out.println(solve(999));
		}
		
		else {
			System.out.println(solve(num));
		}
	}
	
	public static int solve(int num) {
		if (num <= 99) {
			return num;
		}
		
		else {
			int count = 0;
			
			for (int i = 100; i <= num; i++) {
				int first = i / 100;
				int second = (i - (first * 100)) / 10;
				int last = i - (first * 100) - (second * 10);
				
				if (first - second == second - last) {
					count++;
				}
			}
			
			return count + 99;
		}
		
	}
}
