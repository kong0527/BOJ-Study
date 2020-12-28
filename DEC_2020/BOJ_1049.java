import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int guitar = Integer.parseInt(st[0]);
        int num = Integer.parseInt(st[1]);
        int arr[][] = new int[num][2];

        for (int i = 0; i < num; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(solve(guitar, arr, num));

    }
    public static int solve(int guitar, int arr[][], int num) {
        int unitMin = 1001;
        int packMin = 1001;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    packMin = packMin > arr[i][j] ? arr[i][j] : packMin;
                }
                else {
                    unitMin = unitMin > arr[i][j] ? arr[i][j] : unitMin;
                }
            }
        }

        return Math.min(Math.min(packMin * (guitar/6 + 1), unitMin * guitar),
                (packMin * (guitar / 6)) + (unitMin * (guitar % 6)));
    }
}
