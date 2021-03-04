package programmers;

// 비밀지도
public class SecretMap {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
        System.out.println(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if (arr1[i] % 2 == 1 || arr2[i] % 2 == 1) answer[i] = "#" + answer[i];
                else answer[i] = " " + answer[i];
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
        }
        return answer;
    }
}
