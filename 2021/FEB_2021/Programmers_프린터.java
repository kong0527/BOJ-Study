import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> queue = new LinkedList<>();
        Iterator<Print> iter = queue.iterator();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Print(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            boolean flag = false;
            Print cur = queue.poll();
            Iterator it = queue.iterator();

            while(it.hasNext()) {
                Print next = (Print) it.next();
                if (cur.priority < next.priority) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                queue.add(cur);
            }

            else {
                if (cur.num == location) {
                    return ++answer;
                }
                else  {
                    answer++;
                }
            }

        }

        return answer;
    }
}

class Print {
    int priority;
    int num;

    Print (int priority, int num) {
        this.priority = priority;
        this.num = num;
    }
}