import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] st = new String[numbers.length];
        for (int i = 0; i < st.length; i++) {
            st[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(st, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2){
                return (n2+n1).compareTo(n1+n2);
            }
        });

        for (String s : st) {
            answer += s;
        }

        if(st[0].equals("0")) {
            return "0";
        }

        return answer;
    }
}