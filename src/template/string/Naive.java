package template.string;

public class Naive {
    public static void main(String[] args) {
        String text = "THIS IS A TEST TEXT";
        String pattern = "TEXT";
        System.out.println(find(text, pattern));
    }

    private static int find(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) break; // 일치하지 않으면 다음 인덱스로 넘어감
                if (j == pattern.length() - 1) return i; // pattern이 모두 일치하면 시작 인덱스 return
            }
        }
        return -1;
    }
}
