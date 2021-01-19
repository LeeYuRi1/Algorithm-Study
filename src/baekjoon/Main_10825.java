package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] a = new String[n][4];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine().split(" ");
        }

        //Comparator
        Arrays.sort(a, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                        if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
                            return o1[0].compareTo(o2[0]); // 모든 점수 같으면 이름이 사전순으로 증가
                        }
                        return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3])); // 국어, 영어 같으면 수학 점수 감소하는 순서
                    }
                    return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2])); // 국어 점수 같으면 영어 점수 증가하는 순서
                }
                return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1])); // 국어 점수 감소하는 순서
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String[] s : a) {
            sb.append(s[0] + "\n");
        }
        System.out.println(sb);
    }
}
