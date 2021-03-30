package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 30의 배수 = 2,3,5의 배수
// 1. 2,5의 배수이면 0으로 끝나야 함
// 2. 모든 숫자를 더해서 3의 배수가 되면 그 수가 3의 배수임
// 주어진 수가 3의 배수고 0이 존재한다면 항상 30의 배수로 만들 수 있음
// 가장 큰 수는 내림차순을 한 수
public class Main_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Integer> num = new ArrayList<>();
        int sum = 0;
        boolean zero = false;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n == 0) zero = true;
            sum += n;
            num.add(n);
        }

        StringBuilder sb = new StringBuilder();
        if (sum % 3 == 0 && zero) {
            Collections.sort(num, Collections.reverseOrder());
            for (int i = 0; i < num.size(); i++) {
                sb.append(num.get(i));
            }
        } else {
            sb.append(-1);
        }
        System.out.println(sb);

    }
}
