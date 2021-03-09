import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 가장 먼 노드의 간선의 수
        int max = 0;
        // 1번 노드로부터 각 노드의 거리를 저장할 배열
        int distance[] = new int[n+1];
        // 연결 정보를 저장할 이차원 배열
        int arr[][] = new int[n+1][n+1];
        
        // 연결된 곳을 1로 표시한다.
        for (int i = 0; i < edge.length; i++) {
            arr[edge[i][0]][edge[i][1]] = arr[edge[i][1]][edge[i][0]] = 1;
        }
        
        // bfs를 위해 큐를 선언
        Queue<Integer> queue = new LinkedList<>();
        // 시작점인 1번 노드를 넣는다.
        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int i = 2; i <= n; i++){
                // 아직 방문하지 않은 곳이고, 연결되어 있는 곳이라면
                if(distance[i] == 0 && arr[node][i] == 1){
                    // 이전 노드에 간선의 수 + 1
                    distance[i] = distance[node] + 1;
                    queue.add(i);
                    // max 값 갱신
                    max = Math.max(max,distance[i]);
                }
            }            
        }
        
        // max값과 같은 값의 수를 센다.
        for (int num : distance) {
            if (max == num) {
                answer++;
            }
        }

        return answer;
    }
}