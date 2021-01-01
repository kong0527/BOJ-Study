import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int start = Integer.parseInt(st[0]);
        int finish = Integer.parseInt(st[1]);
        System.out.println(solve(start, finish));
    }

    public static int solve(int start, int finish) {
        int arr[] = new int[finish+1];
        int flag = 1;
        int sum = 0;
        int idx = 1;

        while (idx <= finish) {
            for (int i = 0; i < flag; i++) {
                if (idx > finish) {
                    break;
                }
                arr[idx++] = flag;
            }
            flag++;
        }

        for (int i = start; i <= finish; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
