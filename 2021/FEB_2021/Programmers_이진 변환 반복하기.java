class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int count = 0;

        while (true) {
            count++; // 이진변환 횟수 count
            for (int i = 0; i < s.length(); i++) {
                // s에 0이 있으면 그 수를 센다.
                if (Character.toString(s.charAt(i)).equals("0") ) {
                    zeroCount++;
                }
            }
            // s의 0을 모두 지워준다.
            s = s.replaceAll("0", "");

            // 0 제거 과정 후, s가 1이 되었는지 체크
            if (s.equals("1")) {
                break;
            }

            // s의 길이를 이진수로 변환한다.
            s = Integer.toBinaryString(s.length());

            // s가 1이 되었는지 다시 체크
            if(s.equals("1")) {
                break;
            }
        }

        answer[0] = count;
        answer[1] = zeroCount;
        return answer;
    }
}