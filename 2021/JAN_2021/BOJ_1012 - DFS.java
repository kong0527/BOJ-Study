import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static int M;
    static int N;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        int ans[] = new int[testNum];

        for (int i = 0; i < testNum; i++) {
            String st[] = br.readLine().split(" ");
            M = Integer.parseInt(st[0]);
            N = Integer.parseInt(st[1]);
            arr = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < Integer.parseInt(st[2]); j++) {
                String loc[] = br.readLine().split(" ");
                arr[Integer.parseInt(loc[1])][Integer.parseInt(loc[0])] = 1;
            }
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        ans[i] += 1;
                    }
                }
            }

        }

        for (int n : ans) {
            System.out.println(n);
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int bx = x + dx[i];
            int by = y + dy[i];

            if (bx >= 0 && by >= 0 && bx < N && by < M) {
                if (arr[bx][by] == 1 && !visited[bx][by]) {
                    dfs(bx, by);
                }
            }
        }
    }
}
