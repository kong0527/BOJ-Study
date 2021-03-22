import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int length;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        dfs("", 0);
        System.out.println(sb.toString());
    }

    public static void dfs(String num, int count) {
        // 네 숫자가 모두 뽑아지면 sb에 추가한다.
        if (count == length) {
            sb.append(num + '\n');
            return ;
        }

        for (int i = 1; i < 10; i++) {
            // 현재까지의 num에 1부터 9까지 숫자를 붙여가며 소수인지 검사한다.
            if (isPrime(Integer.parseInt(num + i))) {
                dfs(num + i, count + 1);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            // num으로 i를 나누었을때 나머지가 0이면 바로 for문 탈출
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
