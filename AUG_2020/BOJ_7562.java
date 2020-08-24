import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_7562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int ans[] = new int[num];
		
		for (int i = 0; i < ans.length; i++) {
			int N = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			s = br.readLine().split(" ");
			int x2 = Integer.parseInt(s[0]);
			int y2 = Integer.parseInt(s[1]);
			
			ans[i] = solve(N, x1, y1, x2, y2);
			
		}
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static int solve(int N, int x1, int y1, int x2, int y2) {
		int visited[][] = new int[N][N];
		
		// Arrays.fill은 이차원 배열에 사용 불가!
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = -1;
			}
		}
		
		visited[x1][y1] = 0;
		
		Queue<Location> queue = new LinkedList<Location>();
		Location loc;
		queue.add(new Location(x1, y1));
		
		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			if (x >= N || y >= N || x < 0 || y < 0 || (x1 == x2 && y1 == y2)) {
				break;
			}
			
			if (x-2 >= 0 && y-1 >= 0 && visited[x-2][y-1] == -1) {
				queue.add(new Location(x-2, y-1));
				visited[x-2][y-1] = visited[x][y]+1;
			}
			
			if (x-2 >= 0 && y+1 < N && visited[x-2][y+1] == -1) {
				queue.add(new Location(x-2, y+1));
				visited[x-2][y+1] = visited[x][y]+1;
			}
			
			if (x-1 >= 0 && y-2 >= 0 && visited[x-1][y-2] == -1) {
				queue.add(new Location(x-1, y-2));
				visited[x-1][y-2] = visited[x][y]+1;
			}
			
			if (x-1 >= 0 && y+2 < N && visited[x-1][y+2] == -1) {
				queue.add(new Location(x-1, y+2));
				visited[x-1][y+2] = visited[x][y]+1;
			}
			
			if (x+1 < N && y-2 >= 0 && visited[x+1][y-2] == -1) {
				queue.add(new Location(x+1, y-2));
				visited[x+1][y-2] = visited[x][y]+1;
			}
			
			if (x+1 < N && y+2 < N && visited[x+1][y+2] == -1) {
				queue.add(new Location(x+1, y+2));
				visited[x+1][y+2] = visited[x][y]+1;
			}
			
			if (x+2 < N && y-1 >= 0 && visited[x+2][y-1] == -1) {
				queue.add(new Location(x+2, y-1));
				visited[x+2][y-1] = visited[x][y]+1;
			}
			
			if (x+2 < N && y+1 < N && visited[x+2][y+1] == -1) {
				queue.add(new Location(x+2, y+1));
				visited[x+2][y+1] = visited[x][y]+1;
			}

		}

		return visited[x2][y2];
	}
}
