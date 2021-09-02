package template.string;

public class Naive {
    public static void main(String[] args) {
        String text = "TETT TTET TEST TEXT TEST";
        String pattern = "TEST";
        find(text, pattern);
    }

    private static void find(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) break; // 일치하지 않으면 다음 인덱스로 넘어감
                if (j == pattern.length() - 1) System.out.println(i + 1 + "번째에서 발견"); // pattern이 모두 일치하면 시작 인덱스 출력
            }
        }
    }
}
