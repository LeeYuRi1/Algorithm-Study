package programmers;

// 문자열 내 p와 y의 개수
public class NumberOfPAndY {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p') {
                count++;
            }
            if (c == 'y') {
                count--;
            }
        }
        return count == 0;
    }
}
