class Solution {
    public int solution(String name) {
        int answer = 0;
        boolean flag = false;

        // 알파벳 변경
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (ch == 'A') {
                flag = true;
            }

            if (ch <= 'N') {
                answer += ch - 'A';
            }

            else {
                answer += 'Z' - ch + 1;
            }
        }

        // 위치 변경
        int min = name.length() - 1;

        if (flag) {
            int prev = 0;
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == 'A') {
                    prev = i - 1;
                    while (i < name.length() && name.charAt(i) == 'A') {
                        i++;
                    }
                    int tmp = prev * 2 + name.length() - i;
                    min = Math.min(tmp, min);
                }
            }
        }


        return answer + min;

    }
}