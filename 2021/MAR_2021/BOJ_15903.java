import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        long answer = 0;
        st = br.readLine().split(" ");
        // 카드에 써진 숫자들을 저장할 pq
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 숫자들을 pq에 넣는다.
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st[i]));
        }

        // pq에서 숫자 두 개를 빼서 더한 후 다시 넣는다.
        for (int i = 0; i < m; i++) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            pq.add(num1+num2);
            pq.add(num1+num2);
        }

        // pq의 숫자들을 더해나간다.
        for (int i = 0; i < n; i++) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
