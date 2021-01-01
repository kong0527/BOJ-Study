import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		int ans[] = new int[testNum];
		for (int i = 0; i < testNum; i++) {
			String st[] = br.readLine().split(" ");
			int docNum = Integer.parseInt(st[0]);
			int priority = Integer.parseInt(st[1]);
			String s[] = br.readLine().split(" ");
			int docPrior[] = new int[docNum];
			for (int j = 0; j < docNum; j++) {
				docPrior[j] = Integer.parseInt(s[j]);
			}
			ans[i] = solve(priority, docPrior);
		}
		
		for (int num : ans) {
			System.out.println(num);
		}

	}
	
	public static int solve(int priority, int[] docPrior) {
		if (docPrior.length == 1) {
			return 1;
		}
		
		else {
			int count = 0;
			Queue<Doc> queue = new LinkedList<Doc>();
			for (int i = 0; i < docPrior.length; i++) {
				queue.add(new Doc(i, docPrior[i]));
			}
			while (!queue.isEmpty()) {
				Doc curr = queue.poll();
				Iterator it = queue.iterator();
				boolean flag = false;
				while (it.hasNext()) {
					Doc next = (Doc) it.next();
					if (curr.pri < next.pri) {
						flag = true;
						break;
					}
				}
				if (flag) {
					queue.add(curr);
				}
				else {
					if (curr.num == priority) {
						return ++count;
					}
					else {
						count++;
					}					
				}
			}
		}
		return 0;
	}
	
	static class Doc {
		int num;
		int pri;
		
		public Doc(int num, int pri) {
			this.num = num;
			this.pri = pri;
		}
	}
}
