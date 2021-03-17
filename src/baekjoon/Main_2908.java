package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2908 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(new StringBuffer(input[0]).reverse().toString());
        int b = Integer.parseInt(new StringBuffer(input[1]).reverse().toString());
        System.out.println(Math.max(a, b));
    }
}
