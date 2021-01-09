import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arr[] = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solve(arr);
    }

    public static void solve (int[] arr) {
        // 산술평균
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int mean = Math.round((float) sum / arr.length);

        // 중앙값
        Arrays.sort(arr);
        int mid = arr[arr.length/2];

        // 최빈값
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            else {
                int val = map.get(arr[i]);
                val++;
                map.put(arr[i], val);
            }
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        int max = -1;
        List<Integer> ans = new ArrayList<>();

        for (Integer key : keySetList) {
            if (max == -1) {
                max = map.get(key);
                ans.add(key);
            }
            else {
                if (max == map.get(key)) {
                    ans.add(key);
                }
                else {
                    break;
                }
            }
        }

        int mode = 0;
        if (ans.size() == 1) {
            mode = ans.get(0);
        }
        else {
            Collections.sort(ans);
            mode = ans.get(1);
        }


        // 범위
        int range = arr[arr.length-1] - arr[0];

        System.out.println(mean);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}
