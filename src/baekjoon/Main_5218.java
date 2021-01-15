package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            System.out.print("Distances: ");
            for (int i = 0; i < s[0].length(); i++) {
                int x = s[0].charAt(i) - 'A' + 1;
                int y = s[1].charAt(i) - 'A' + 1;
                if (y >= x) {
                    System.out.print((y - x) + " ");
                } else {
                    System.out.print(((y + 26) - x) + " ");
                }
            }
            System.out.println();
        }
    }
}
