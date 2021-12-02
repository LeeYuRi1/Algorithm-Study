package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 30의 배수 = 2,3,5의 배수
// 1. 2,5의 배수이면 0으로 끝나야 함
// 2. 모든 숫자를 더해서 3의 배수가 되면 그 수가 3의 배수임
// 주어진 수가 3의 배수고 0이 존재한다면 항상 30의 배수로 만들 수 있음
// 가장 큰 수는 내림차순을 한 수
public class Main_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int[] num = new int[input.length];
        boolean zero = false;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            num[i] = Integer.parseInt(input[i]);
            if (num[i] == 0) zero = true;
            sum += num[i];
        }

        StringBuilder sb = new StringBuilder();
        if (zero && sum % 3 == 0) {
            Arrays.sort(num);
            for (int i : num) sb.append(i);
            System.out.println(sb.reverse());
        } else {
            System.out.println(-1);
        }
    }
}
