import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] original;
    static int[][] copy;
    static int answer;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);

        original = new int[n][m];
        copy = new int[n][m];
        answer = -1;

        // 원본을 저장할 배열과 원본의 복사본 두 개의 배열이 필요
        for(int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                original[i][j] = copy[i][j] = Integer.parseInt(st[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                // 아무것도 없는 곳이면 벽을 세운다. (백트래킹)
                if(original[i][j] == 0) {
                    copy[i][j] = 1;
                    select(1);
                    copy[i][j] = 0;
                }
            }
        }
        System.out.println(answer);
    }

    // 가능한 모든 곳에 벽을 세운다.
    public static void select(int wall) {
        // 벽을 세울 곳이 전부 정해지면 bfs
        if(wall == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(copy[i][j] == 0) {
                    copy[i][j] = 1;
                    select(wall+1);
                    copy[i][j] = 0;
                }
            }
        }
    }
    public static void bfs() {
        int[][] tmp = new int[n][m];

        // 바이러스를 퍼트릴 tmp 배열 생성
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = copy[i][j];
            }
        }

        Queue<Location> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 바이러스가 있는 곳을 큐에 넣는다.
                if (tmp[i][j] == 2) {
                    q.add(new Location(i, j));
                }
            }
        }

        // 바이러스를 bfs로 퍼트리는 과정
        while(!q.isEmpty()) {
            Location p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int bx = x + dx[i];
                int by = y + dy[i];
                if(bx >= 0 && by >= 0 && bx < n && by < m) {
                    if(tmp[bx][by] == 0) {
                        tmp[bx][by] = 2;
                        q.add(new Location(bx, by));
                    }
                }
            }
        }

        // bfs가 끝난 후 바이러스가 퍼지지 않은 곳의 갯수를 센다.
        int count = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0)
                    count++;
            }
        }

        // answer값 갱신
        answer = Math.max(count, answer);
    }
}

class Location {
    int x;
    int y;

    public Location (int x, int y) {
        this.x = x;
        this.y = y;
    }
}