import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		int arr[][] = new int[101][101];
		for (int i = 0; i < num; i++) {
			String st[] = br.readLine().split(" ");
			int x = Integer.parseInt(st[0]);
			int y = Integer.parseInt(st[1]);
			for (int j = x; j < x+10; j++) {
				for (int z = y; z < y+10; z++) {
					if (arr[j][z] == 0) {
						arr[j][z] = 1;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
	
/*	public static int solve (int[][] arr, int num) {
		int width[] = new int[num];
		int height[] = new int[num];
		
		for (int i = 0; i < num; i++) {
			width[i] = arr[i][0];
		}
		
		for (int i = 0; i < num; i++) {
			height[i] = arr[i][1];
		}
		
		Arrays.sort(width);
		Arrays.sort(height);
		
		int totalWidth = (width[num-1] + 10 - width[0]) * (height[num-1] + 10 - height[0]);
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == j) {
					continue;
				}
				if (checkValue(arr[i][0], arr[j][0]) > 10 || checkValue(arr[i][1], arr[j][1]) > 10) {
					continue;
				}
				else {
					int minus = checkValue(arr[i][0], arr[j][0]) * checkValue(arr[i][1], arr[j][1]);
					totalWidth -= checkValue(arr[i][0], arr[j][0]) * checkValue(arr[i][1], arr[j][1]);
				}				
			}
		}
	
		return totalWidth;
	}
	
	public static int checkValue(int m, int n) {
		int value = m - n;
		if (value < 0) {
			return value * -1;
		}
		else {
			return value;
		}
	}*/

