import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1764 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);
		int M = Integer.parseInt(st[1]);
		
		Set<String> set = new HashSet<>();
		ArrayList<String> ans = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			set.add(s);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				ans.add(s);
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		
		for (String s : ans) {
			System.out.println(s);
		}
	}

}
