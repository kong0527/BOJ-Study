import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> ans = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                // 다른 인덱스만 뽑아야 하므로
                if (i == j) {
                    continue;
                }
                // 중복값을 제거하기 위해 Set에 담는다.
                ans.add(numbers[i] + numbers[j]);
            }
        }
        
        // Set에 담긴 값들을 answer에 넣는다.
        int[] answer = new int[ans.size()];
        int idx = 0;
        Iterator iter = ans.iterator();	
        while(iter.hasNext()) {
            answer[idx++] = (int) iter.next();
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}