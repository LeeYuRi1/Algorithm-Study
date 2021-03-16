package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int minPackage = 1000;
        int minPiece = 1000;
        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            if (minPackage > Integer.parseInt(s[0])) minPackage = Integer.parseInt(s[0]);
            if (minPiece > Integer.parseInt(s[1])) minPiece = Integer.parseInt(s[1]);
        }

        int result1 = ((n / 6) + 1) * minPackage;
        int result2 = n * minPiece;
        int result3 = ((n / 6) * minPackage) + ((n % 6) * minPiece);
        System.out.println(Math.min(Math.min(result1, result2), result3));
    }
}
