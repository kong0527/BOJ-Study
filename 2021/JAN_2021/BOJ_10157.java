import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10157 {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int C = Integer.parseInt(st[0]);
        int R = Integer.parseInt(st[1]);
        int audience = Integer.parseInt(br.readLine());
        solve(C, R, audience);
    }

    public static void solve(int C, int R, int audience) {
        if (audience > C * R) {
            System.out.println("0");
            return ;
        }

        int arr[][] = new int[R][C];
        int count = 1;
        int x = R - 1;
        int y = 0;
        int d = 0;

        while (count != audience) {
            arr[x][y] = count;
            int x1 = x + dx[d];
            int y1 = y + dy[d];

            if (x1 < 0 || y1 < 0 || x1 >= R || y1 >= C || arr[x1][y1] != 0) {
                d = (d+1) % 4;
                x1 = x + dx[d];
                y1 = y + dy[d];
            }

            x = x1;
            y = y1;
            count++;
        }

        System.out.println((y+1) + " " + (R-x));
    }
}
