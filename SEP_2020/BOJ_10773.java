import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solve2(arr));
	}
	
	public static int solve(int arr[]) {
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && arr[i] == 0) {
				int idx = i-1;
				while (arr[idx] == 0) {
					idx--;
				}
				arr[idx] = 0;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}
	
	//solve by Stack
	public static int solve2(int arr[]) {
		int sum = 0;
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				stack.pop();
			}
			else {
				stack.push(arr[i]);
			}
		}
		
		for (int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}
		
		return sum;
	}
}