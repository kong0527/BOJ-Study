import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (!hash.containsKey(participant[i])) {
                hash.put(participant[i], 1);
            }

            else {
                int value = hash.get(participant[i]);
                hash.put(participant[i], value + 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (hash.get(completion[i]) == 1) {
                hash.remove(completion[i]);
            }

            else {
                int value = hash.get(completion[i]);
                hash.put(completion[i], value - 1);
            }
        }

        for (String key : hash.keySet()) {
            answer = key;
        }

        return answer;
    }
}