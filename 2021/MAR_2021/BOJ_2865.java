import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int people = Integer.parseInt(st[0]);
        int genre = Integer.parseInt(st[1]);
        int finals = Integer.parseInt(st[2]);
        float answer = 0;
        // 참가자, 제일 높은 점수 쌍을 저장할 map 선언
        HashMap<Integer, Float> map = new HashMap<>();

        for (int i = 0; i < genre; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < people * 2; j+=2) {
                int participant = Integer.parseInt(st[j]);
                float score = Float.parseFloat(st[j+1]);
                // map에 이미 있는 참가자면 기존값과 새 값중 더 큰 값을 저장
                if (map.containsKey(participant)) {
                    map.put(participant, score > map.get(participant) ? score : map.get(participant));
                }
                // map에 없는 참가자라면 현재 점수를 넣는다.
                else {
                    map.put(participant, score);
                }
            }
        }

        // map을 value 기준으로 내림차순
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int count = 0;
        // 본선에 참가할 수 있는 사람의 수 만큼만 점수를 더한다.
        for (Integer key : keySetList) {
            if (count >= finals) {
                break;
            }
            answer += map.get(key);
            count++;
        }

        System.out.printf("%.1f\n", answer);

    }
}
