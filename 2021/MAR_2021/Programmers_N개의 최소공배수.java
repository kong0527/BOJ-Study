import java.math.BigInteger;

class Solution {
    public int solution(int[] arr) {
        // answer의 초기값 설정
        int answer = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // answer과 다음 수의 최소공배수를 구해서 계속 업데이트 한다
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    // 두 수의 최대공약수를 구하는 함수
    public int gcd(int x, int y) {
        BigInteger b1 = BigInteger.valueOf(x);
        BigInteger b2 = BigInteger.valueOf(y);
        int gcd = b1.gcd(b2).intValue();
        return gcd;
    }

    // 두 수의 최소공배수를 구하는 함수
    public int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}