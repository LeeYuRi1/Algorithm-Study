package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 실수에서 이분 탐색 수행할 때 주의할 점!
// 1. while(min <= max) 불가능: 실수는 오차가 있어서 사용할 수 없음
// 2. min = mid + 1, max = mid - 1 불가능: 그 사이에 정답이 있을 수 있음

// d(두 빌딩 사이의 떨어진 거리)가 작아지면 h(높이)가 커짐, d가 커지면 h가 작아짐
// h > c : d를 크게 만들어야 함
// h < c : d를 작게 만들어야 함
public class Main_2022 {
    private static double x, y, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        x = Double.parseDouble(input[0]);
        y = Double.parseDouble(input[1]);
        c = Double.parseDouble(input[2]);

        double min = 0, max = Math.min(x, y), mid;
        while (max - min > 1e-6) {
            mid = (min + max) / 2.0;
            if (check(mid)) min = mid;
            else max = mid;
        }
        System.out.println(String.format("%.3f", min));
    }

    private static boolean check(double d) {
        double h1 = Math.sqrt(x * x - d * d);
        double h2 = Math.sqrt(y * y - d * d);
        return (h1 * h2) / (h1 + h2) > c;
    }
}
