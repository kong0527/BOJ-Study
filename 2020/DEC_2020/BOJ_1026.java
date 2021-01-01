import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arrA[] = new int[num];
        Integer arrB[] = new Integer[num];
        String st[] = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arrA[i] = Integer.parseInt(st[i]);
        }
        st = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arrB[i] = Integer.parseInt(st[i]);
        }

        System.out.println(solve(arrA, arrB));
    }

    public static int solve(int[] arrA, Integer[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());
        int sum = 0;

        for (int i = 0; i < arrA.length; i++) {
            sum += arrA[i] * arrB[i];
        }

        return sum;
    }
}
