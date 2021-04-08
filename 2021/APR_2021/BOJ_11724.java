import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        size = Integer.parseInt(st[0]);
        int num = Integer.parseInt(st[1]);
        int count = 0;
        arr = new int[size+1][size+1];
        visited = new boolean[size+1];

        // 입력받은 연결 정보를 배열에 표현
        for (int i = 0; i < num; i++) {
            st = br.readLine().split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);
            arr[x][y] = arr[y][x] = 1;
        }

        // 정점 i를 방문하지 않았으면 dfs
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x) {
        // 정점 x를 방문했다고 표시
        visited[x] = true;

        // 정점 x와 연결된 아직 방문하지 않은 다른 정점들을 방문한다.
        for (int i = 1; i <= size; i++) {
            if (!visited[i] && arr[x][i] == 1) {
                dfs(i);
            }
        }
    }
}