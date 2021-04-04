import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String explosion = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // stack에 입력받은 문자열을 하나씩 넣는다.
            stack.push(s.charAt(i));

            // explosion의 길이보다 stack의 사이즈가 크면 폭발 문자열이 포함되어있는지 검사한다.
            if (stack.size() >= explosion.length()) {
                boolean flag = true;
                for (int j = 0; j < explosion.length(); j++) {
                    // 스택에서 문자열을 꺼내며 폭발 문자열과 일치하는지 확인한다.
                    if (stack.get(stack.size() - explosion.length() + j) != explosion.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                // 폭발 문자열이 있으면 스택에서 꺼낸다.
                if (flag) {
                    for (int j = 0; j < explosion.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack) {
            sb.append(ch);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        }

        else {
            System.out.println(sb.toString());
        }
    }
}