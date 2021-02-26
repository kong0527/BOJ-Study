class Solution {
    static boolean visited[][];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 방문 여부를 표시하기 위한 배열 선언
       visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문한 적이 없고 연결된 컴퓨터가 있다면 dfs 수행
                if (!visited[i][j] && computers[i][j] == 1) {
                    answer++;
                    dfs(i, j, computers, n);
                }
            }
        }
        return answer;
    }

    public void dfs(int x, int y, int[][] computers, int n) {
        // [x][y] 와 [y][x]는 무조건 같으므로 [y][x]도 방문한 것으로 표시
        visited[x][y] = true;
        visited[y][x] = true;

        for (int i = 0; i < n; i++) {
            // y 컴퓨터와 연결된 다른 컴퓨터가 있으면 dfs 수행
            if (!visited[y][i] && computers[y][i] == 1) {
                dfs(y, i, computers, n);
            }
        }

    }
}