import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            }
            else {
                break;
            }
        }

        for (int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if (win_nums[i] > lottos[j]) {
                    continue;
                }

                if (win_nums[i] == lottos[j]) {
                    count++;
                    break;
                }

                if (win_nums[i] > lottos[j]) {
                    break;
                }
            }
        }

        answer[0] = rank(count + zeroCount);
        answer[1] = rank(count);

        return answer;
    }
    
        public static int rank(int num) {
        if (num == 6) {
            return 1;
        }

        else if (num == 5) {
            return 2;
        }

        else if (num == 4) {
            return 3;
        }

        else if (num == 3) {
            return 4;
        }

        else if (num == 2) {
            return 5;
        }

        else {
            return 6;
        }
    }
}