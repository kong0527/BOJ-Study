import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    static int node;
    static int vertex;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int answer = 0;
        node = Integer.parseInt(st[0]);
        vertex = Integer.parseInt(st[1]);
        parent = new int[node+1];
        pq = new PriorityQueue<>();

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < vertex; i++) {
            st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int e = Integer.parseInt(st[1]);
            int v = Integer.parseInt(st[2]);
            pq.add(new Edge(s, e, v));
        }

        // 크루스칼 알고리즘
        for (int i = 0; i < vertex; i++) {
            Edge tmp = pq.poll();
            int a = find(tmp.s);
            int b = find(tmp.e);

            if (a == b) {
                continue;
            }

            union(a, b);

            answer += tmp.v;
        }

        System.out.println(answer);
    }

    // a의 부모를 찾는 함수
    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        parent[a] = find(parent[a]);
        return parent[a];
    }

    // 둘을 연결하는 과정
    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent != bParent) {
            parent[aParent] = b;
        }

        // 둘의 부모가 같으면 사이클이 생성됨
        else {
            return ;
        }
    }
}

class Edge implements Comparable<Edge> {
    int s;
    int e;
    int v;

    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o) {
        return o.v >= this.v ? -1 : 1;
    }
}
