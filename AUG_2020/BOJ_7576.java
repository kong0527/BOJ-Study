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

public class BOJ_7576 {
	static int M;
	static int N;
	static int visited[][];
	static int arr[][];
	static int YES = 1;
	static int NO = -1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		M = Integer.parseInt(st[0]);
		N = Integer.parseInt(st[1]);
		arr = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				visited[i][j] = NO;
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Location> queue = new LinkedList<Location>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && visited[i][j] == NO) {
					queue.add(new Location(i, j));
				}
			}
		}
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int bx = loc.x;
			int by = loc.y;
			
			if (bx >= N || by >= M || bx < 0 || by < 0) {
				break;
			}
			
			//위로 올라가는 경우
			if (bx-1 >= 0 && arr[bx-1][by] == 0 && visited[bx-1][by] == NO) {
				queue.add(new Location(bx-1, by));
				arr[bx-1][by] = arr[bx][by] + 1;
				visited[bx-1][by] = YES;
			}
			
			//아래로 올라가는 경우
			if (bx+1 < N && arr[bx+1][by] == 0 && visited[bx+1][by] == NO) {
				queue.add(new Location(bx+1, by));
				arr[bx+1][by] = arr[bx][by] + 1;;
				visited[bx+1][by] = YES;
			}
			
			//왼쪽으로 가는 경우
			if (by-1 >= 0 && arr[bx][by-1] == 0 && visited[bx][by-1] == NO) {
				queue.add(new Location(bx, by-1));
				arr[bx][by-1] = arr[bx][by] + 1;;
				visited[bx][by-1] = YES;
			}
			
			//오른쪽으로 가는 경우
			if (by+1 < M && arr[bx][by+1] == 0 && visited[bx][by+1] == NO) {
				queue.add(new Location(bx, by+1));
				arr[bx][by+1] = arr[bx][by] + 1;;
				visited[bx][by+1] = YES;
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0 && visited[i][j] == NO) {
					System.out.println(-1);
					return ;
				}
				count = Math.max(count, arr[i][j]);
			}
		}
		
		System.out.println(count-1);
	}
}
