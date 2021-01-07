package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        while (n-- > 0) {
            String[] line = bf.readLine().split(",");
            System.out.println(Integer.parseInt(line[0]) + Integer.parseInt(line[1]));
        }
    }
}
