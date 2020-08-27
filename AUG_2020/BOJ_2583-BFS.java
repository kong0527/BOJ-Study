import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2583 {
	static int M;
	static int N;
	static int arr[][];
	static int visited[][];
	static int rectangles[][];
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		int num = Integer.parseInt(s[2]);
		
		arr = new int[M][N];
		visited = new int[M][N];
		
		for (int i = 0; i < num; i++) {
			s = br.readLine().split(" ");
			int Ly = Integer.parseInt(s[0]);
			int Lx = Integer.parseInt(s[1]);
			int Ry = Integer.parseInt(s[2]);
			int Rx = Integer.parseInt(s[3]);
			
			
			for (int x = Lx; x < Rx; x++) {
				for (int y = Ly; y < Ry; y++) {
					arr[x][y] = 1;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0 && visited[i][j] == 0) {
					count = 1;
					list.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Location> queue = new LinkedList<Location>();
		Location loc;
		queue.add(new Location(x, y));
		visited[x][y] = 1;
		
		while (!queue.isEmpty()) {
			loc = queue.poll();
			x = loc.x;
			y = loc.y;
			
			if (x > M || y > N || x < 0 || y < 0) {
				break;
			}
			
			//위로 올라가는 경우
			if (x-1 >= 0 && arr[x-1][y] == 0 && visited[x-1][y] == 0) {
				visited[x-1][y] = 1;
				count++;
				queue.add(new Location(x-1, y));
			}
			
			//아래로 올라가는 경우
			if (x+1 < M && arr[x+1][y] == 0 && visited[x+1][y] == 0) {
				visited[x+1][y] = 1;
				count++;
				queue.add(new Location(x+1, y));
			}
			
			//왼쪽으로 가는 경우
			if (y-1 >= 0 && arr[x][y-1] == 0 && visited[x][y-1] == 0) {
				visited[x][y-1] = 1;
				count++;
				queue.add(new Location(x, y-1));
			}
			
			//오른쪽으로 가는 경우
			if (y+1 < N && arr[x][y+1] == 0 && visited[x][y+1] == 0) {
				visited[x][y+1] = 1;
				count++;
				queue.add(new Location(x, y+1));
			}
		}
		
		return count;
	}
