import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스를 입력받는 변수
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            // AC 언어를 입력받는 변수
            String s = br.readLine();
            // 배열의 사이즈를 입력받는 변수
            int size = Integer.parseInt(br.readLine());
            // 배열 내용을 입력받음
            String tmp = br.readLine();
            // 양쪽 끝의 [ 와 ] 를 제거하고 , 를 기준으로 배열에 담는다.
            String st[] = tmp.substring(1, tmp.length()-1).split(",");
            Deque<String> arr = new ArrayDeque<>();
            // 만들어진 배열을 덱에 넣는다.
            for (int j = 0; j < size; j++) {
                arr.add(st[j]);
            }
            solve(s, arr);
        }
    }

    public static void solve(String func, Deque<String> arr) {
        // 덱의 출력 방향을 바꿀지 판단하는 변수
        boolean reverse = false;
        for (int i = 0; i <func.length(); i++) {
            char ch = func.charAt(i);
            // R이면 출력 방향을 바꾼다.
            if (ch == 'R') {
                reverse = !reverse;
            }
            else {
                // 덱의 사이즈가 0일 때 제거하려고 하면 error를 출력한다.
                if (arr.size() == 0) {
                    System.out.println("error");
                    return ;
                }
                // 출력 방향이 바뀌어있으면 마지막 원소를 remove
                if (reverse) {
                    arr.removeLast();
                }
                // 출력 방향이 그대로면 첫 번째 원소를 remove
                else {
                    arr.removeFirst();
                }
            }
        }
        // 끝났으면 결과물을 형식에 맞게 출력해준다.
        StringBuilder sb = new StringBuilder("[");
        while (!arr.isEmpty()) {
            sb.append(reverse ? arr.removeLast() : arr.removeFirst());
            if (arr.size() != 0)
                sb.append(',');
        }
        sb.append(']');
        System.out.println(sb);
    }
}