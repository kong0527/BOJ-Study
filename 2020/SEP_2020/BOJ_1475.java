import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1475 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[9];
		String st = br.readLine();
		
		for (int i = 0; i < st.length(); i++) {
			int idx = st.charAt(i) - '0';
			
			if (idx == 9) {
				idx = 6;
			}
			
			arr[idx] += 1;
		}
		
		arr[6] = Math.round((float)arr[6]/2);
		Arrays.sort(arr);
		System.out.println(arr[8]);
	}

}
