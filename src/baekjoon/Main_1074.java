package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1074 {
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        System.out.println(print((int) Math.pow(2, Integer.parseInt(input[0])), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
    }

    private static int print(int n, int x, int y) {
        if (n == 1) {
            return ans;
        } else {
            int l = n * n / 4;
            if (x < n / 2) {
                if (y < n / 2) {
                    //왼쪽 위
                    return print(n / 2, x, y);
                } else {
                    //오른쪽 위
                    ans += l;
                    return print(n / 2, x, y - n / 2);
                }
            } else {
                if (y < n / 2) {
                    //왼쪽 아래
                    ans += l * 2;
                    return print(n / 2, x - n / 2, y);
                } else {
                    //오른쪽 아래
                    ans += l * 3;
                    return print(n / 2, x - n / 2, y - n / 2);
                }
            }
        }
    }
}
