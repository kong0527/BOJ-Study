import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        // pq를 사용해 최대 힙 생성
        // pq는 최소 힙 처럼 작동하기 때문에 Collections.reverseOrder() 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                // num이 0일 때 힙이 비어있으면 0 출력
                if (pq.isEmpty()) {
                    System.out.println("0");
                }
                // num이 0일 때 힙이 0이 아니면 poll
                else {
                    System.out.println(pq.poll());
                }
            }
            // num이 0이 아니면 pq에 값 삽입
            else {
                pq.add(num);
            }
        }
    }
}
