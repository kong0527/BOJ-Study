import java.util.*;

class Solution {
    HashMap<String, Integer> map;
    static boolean visited[];

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            // course의 개수별 최댓값을 저장할 변수
            int max = -1;
            // course와 빈도수를 저장할 hashmap
            map = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                String order[] = new String[orders[j].length()];
                visited = new boolean[order.length];
                // orders의 원소를 문자별로 String 배열에 저장
                for (int k = 0; k < order.length; k++) {
                    order[k] = Character.toString(orders[j].charAt(k));
                }
                // order 배열을 알파벳 순서대로 정렬한다.
                Arrays.sort(order);
                // order 배열로 조합을 구한다.
                combination(order, visited, 0, order.length, course[i]);
            }

            // map을 내림차순으로 정렬
            List<String> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

            for (String key : keySetList) {
                if (max == -1) {
                    // 무조건 주문이 두 번 이상 되어야 하므로 max가 1인 경우는 그냥 for문 탈출
                    if (map.get(key) == 1) {
                        break;
                    }
                    // ans에 넣어준다.
                    max = map.get(key);
                    ans.add(key);
                }
                else {
                    // 최댓값과 같은 값이면 ans에 넣어주고 아니면 탈출한다.
                    if (max == map.get(key)) {
                        ans.add(key);
                    }
                    else {
                        break;
                    }
                }
            }
        }

        // ans에 담긴 값들을 answer 배열에 저장한다.
        answer = new String[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        // 사전순 정렬
        Arrays.sort(answer);

        return answer;
    }

    void combination(String[] order, boolean[] visited, int start, int n, int r) {
        // 조합을 구하는 과정
        if (r == 0) {
            pick(order,visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(order, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    void pick(String[] order, boolean[] visited, int n) {
        String picked = "";
        // 조합의 결과를 String에 저장
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                picked += order[i];
            }
        }

        // map에 이미 있는 조합이면 value를 1 증가시킨다.
        if (map.containsKey(picked)) {
            int value = map.get(picked);
            map.put(picked, value + 1);
        }

        // map에 존재하지 않으면 새로 넣어준다.
        else {
            map.put(picked, 1);
        }
    }
}