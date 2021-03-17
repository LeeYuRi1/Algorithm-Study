package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String ascending = "1 2 3 4 5 6 7 8";
        String descending = "8 7 6 5 4 3 2 1";

        String result = "";
        if (ascending.equals(input)) {
            result = "ascending";
        } else if (descending.equals(input)) {
            result = "descending";
        } else {
            result = "mixed";
        }
        System.out.println(result);
    }
}
