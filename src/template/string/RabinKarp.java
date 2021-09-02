package template.string;

public class RabinKarp {
    public static void main(String[] args) {
        String text = "TETT TTET TEST TEXT TEST";
        String pattern = "TEST";
        find(text, pattern);
    }

    private static void find(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        int textHash = 0, patternHash = 0, power = 1; // 제곱수
        for (int i = 0; i <= textLen - patternLen; i++) {
            if (i == 0) { // 처음에는 해시값 구해주기
                for (int j = 0; j < patternLen; j++) {
                    textHash += text.charAt(patternLen - 1 - j) * power; // 오른쪽부터 2의 j제곱을 곱해서 더해줌
                    patternHash += pattern.charAt(patternLen - 1 - j) * power;
                    if (j < patternLen - 1) power *= 2;
                }
            } else { // 새로운 해시 = 2 * (기존 해시 - 가장 앞문자해시) + 가장 뒷문자해시
                textHash = 2 * (textHash - text.charAt(i - 1) * power) + text.charAt(patternLen - 1 + i);
            }

            if (textHash == patternHash) { // 해시값이 일치한다면 확인
                boolean finded = true;
                for (int j = 0; j < patternLen; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        finded = false;
                        break;
                    }
                }
                if (finded) System.out.println(i + 1 + "번째에서 발견");
            }
        }
    }
}
