package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1259 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            String reverse = new StringBuffer(s).reverse().toString();
            if (s.equals(reverse)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
