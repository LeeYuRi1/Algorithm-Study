package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int s = 0;
        while (m-- > 0) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "add":
                    s = s | (1 << Integer.parseInt(input[1]));
                    break;
                case "remove":
                    s = s & ~(1 << Integer.parseInt(input[1]));
                    break;
                case "check":
                    int x1 = s & (1 << Integer.parseInt(input[1]));
                    if (x1 == 0) sb.append(0 + "\n");
                    else sb.append(1 + "\n");
                    break;
                case "toggle":
                    int x2 = s & (1 << Integer.parseInt(input[1]));
                    if (x2 == 0) s = s | (1 << Integer.parseInt(input[1]));
                    else s = s & ~(1 << Integer.parseInt(input[1]));
                    break;
                case "all":
                    s = 2097150;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
