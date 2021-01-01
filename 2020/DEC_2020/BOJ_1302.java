import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BOJ_1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        HashMap<String, Integer> books = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String st = br.readLine();
            if (!books.containsKey(st)) {
                books.put(st, 0);
            }
            else {
                int count = books.get(st);
                count++;
                books.put(st, count);
            }
        }
        solve(books);
    }

    public static void solve(HashMap<String, Integer> books) {
        //books의 value 내림차순 정렬
        List<String> keySetList = new ArrayList<>(books.keySet());
        Collections.sort(keySetList, (o1, o2) -> (books.get(o2).compareTo(books.get(o1))));
        int max = -1;
        List<String> ans = new ArrayList<>();

        for (String key : keySetList) {
            if (max == -1) {
                max = books.get(key);
                ans.add(key);
            }
            else {
                if (max == books.get(key)) {
                    ans.add(key);
                }
                else {
                    break;
                }
            }
        }
        Collections.sort(ans);
        System.out.println(ans.get(0));
    }
}
