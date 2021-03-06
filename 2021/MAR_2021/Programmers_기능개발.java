import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int answer[] = {};
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 큐에 각 기능이 개발되는데 걸리는 시간을 넣는다.
            queue.add((int)Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        while (!queue.isEmpty()) {
            // 큐에서 값을 빼낸다.
            int tmp = queue.poll();
            // 배포할 수 있는 기능을 세는 변수
            int count = 1;
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                // 큐에서 빼낸 값보다 다음 값이 크면 배포를 할 수 없으므로 break;
                if (tmp < queue.peek()) {
                    break;
                }
                // 큐에서 빼낸 값이 다음 값보다 크면 배포가 가능하므로 count++ 후 큐에서 빼낸다.
                if (tmp >= queue.peek()) {
                    count++;
                    queue.poll();
                }
            }
            // 한 번에 배포가 가능한 기능의 수를 ans에 담는다.
            ans.add(count);
        }

        // ans의 요소들을 answer 배열에 담는다.
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}