package programmers;

import java.util.ArrayList;

// 뉴스 클러스터링
public class Solution_17677 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        split(str1, a1);
        split(str2, a2);

        float n1 = 0; // 교집합
        float n2 = a1.size() + a2.size(); // 합집합
        for (int i = 0; i < a1.size(); i++) {
            for (int j = 0; j < a2.size(); j++) {
                if (!a1.get(i).equals(a2.get(j))) continue;
                a2.set(j, "");
                n1++;
                n2 -= 2;
                break;
            }
        }
        n2 += n1;
        float ans = (n1 == 0 && n2 == 0) ? 1 : (n1 / n2); // 둘 다 공집합이면 1
        return (int) (ans * 65536);
    }

    private static void split(String str, ArrayList<String> a) {
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (!Character.isLetter(c1) || !Character.isLetter(c2)) continue;
            a.add(c1 + "" + c2);
        }
    }
}
