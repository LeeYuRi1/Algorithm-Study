package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10809 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 97; i < 123; i++) {
            char c = (char)i;
            int index = input.indexOf(c);
            System.out.println(index);
        }
    }
}
