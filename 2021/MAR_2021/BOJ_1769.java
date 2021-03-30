import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        recursion(s);
    }

    public static void recursion(String s) {
        // s가 한 자리수이면
        if (s.length() == 1) {
            int num = Integer.parseInt(s);
            // count를 출력한다.
            System.out.println(count);
            // 3 6 9 중 하나이면 YES를, 아니라면 NO를 출력
            if (num == 3 || num == 6 || num == 9) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            return ;
        }

        // s가 한 자리수가 아니면 자릿수를 각각 더해 num에 저장한다.
        long num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += Long.parseLong(Character.toString(s.charAt(i)));
        }
        // 재귀가 진행된 횟수를 1증가한다.
        count++;
        // num으로 다시 재귀를 시작
        recursion(Long.toString(num));
    }
}
