import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(solve(num));
	}
	
	public static int solve(int num) {
		int count = 0;
		if (num == 64) {
			return 1;
		}
		
		while (num >= 0) {
			if (num == 0) {
				return count;
			}
			
			if (num >= 32 && num < 64) {
				num -= 32;
				count++;
			}
			
			else if (num >= 16 && num < 32) {
				num -= 16;
				count++;
			}
			
			else if (num >= 8 && num < 16) {
				num -= 8;
				count++;
			}
			
			else if (num >= 4 && num < 8) {
				num -= 4;
				count++;
			}
			
			else if (num >= 2 && num < 4) {
				num -= 2;
				count++;
			}
			
			else if (num == 1) {
				num -= 1;
				count++;
			}
			
		}
		
		return 0;
	}

}
