import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String s[] = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
        int i[] = {500, 600, 150, 800, 2500, 2000, 6000};
        int ans[] = solution(s, i);

        for (int num : ans) {
            System.out.println(num);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> genreCount = new HashMap<>();
        HashMap<String, Integer[][]> bestTwo = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (genreCount.containsKey(genres[i])) {
                genreCount.put(genres[i], genreCount.get(genres[i]) + plays[i]);
                if (plays[i] > bestTwo.get(genres[i])[0][1]) {
                    int tmp1 = bestTwo.get(genres[i])[0][0];
                    int tmp2 = bestTwo.get(genres[i])[0][1];
                    Integer[][] arr = new Integer[2][2];
                    arr[0][0] = i;  arr[0][1] = plays[i];
                    arr[1][0] = tmp1;   arr[1][1] = tmp2;
                    bestTwo.put(genres[i], arr);
                }

                else if (plays[i] > bestTwo.get(genres[i])[1][1]) {
                    Integer[][] arr = bestTwo.get(genres[i]);
                    arr[1][0] = i;  arr[1][1] = plays[i];
                    bestTwo.put(genres[i], arr);
                }
            }

            else {
                genreCount.put(genres[i], plays[i]);
                Integer[][] arr = new Integer[2][2];
                arr[0][0] = i;  arr[0][1] = plays[i];
                arr[1][0] = -1; arr[1][1] = -1;
                bestTwo.put(genres[i], arr);
            }
        }

        List<String> keySetList = new ArrayList<>(genreCount.keySet());
        Collections.sort(keySetList, (o1, o2) -> (genreCount.get(o2).compareTo(genreCount.get(o1))));

        ArrayList<Integer> arr = new ArrayList<>();
        for (String key : keySetList) {
            if (bestTwo.get(key)[0][0] != -1) {
                arr.add(bestTwo.get(key)[0][0]);
            }

            if (bestTwo.get(key)[1][0] != -1) {
                arr.add(bestTwo.get(key)[1][0]);
            }
        }

        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
