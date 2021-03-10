package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int newNum = n;
        int count = 0;
        while (true) {
            int sum = (newNum / 10) + (newNum % 10);
            newNum = Integer.parseInt((newNum % 10) + "" + (sum % 10));
            count++;
            if (n == newNum) {
                break;
            }
        }
        System.out.println(count);
    }
}
