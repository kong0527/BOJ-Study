import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // skill_tree의 문자열이 스킬 순서에 맞는지 확인할 check 메소드 호출
        for (int i = 0; i < skill_trees.length; i++) {
            answer += check(skill, skill_trees[i]);
        }
        return answer;
    }

    public int check(String skill, String skill_tree) {
        Queue<String> queue = new LinkedList<>();
        // 스킬 순서를 체크할 변수
        int idx = 0;

        // 큐에 skill_tree의 문자열 하나하나를 넣어준다.
        for (int i = 0; i < skill_tree.length(); i++) {
            queue.add(Character.toString(skill_tree.charAt(i)));
        }

        while (!queue.isEmpty()) {
            // 큐에서 문자열을 꺼낸다.
            String s = queue.poll();
            // 이 문자열이 스킬 순서 문자열에 존재할 경우
            if (skill.contains(s)) {
                // 검사해야 하는 스킬 순서 위치와 s가 일치하면 idx를 증가시킨다.
                if (s.equals(Character.toString(skill.charAt(idx)))) {
                    idx++;
                }
                // 아니라면 잘못된 순서이므로 바로 0을 return 해준다.
                else {
                    return 0;
                }
            }
        }
        // 여기까지 잘 왔다면 알맞은 스킬 순서를 가진 스킬트리 이므로 1을 반환한다.
        return 1;
    }
}