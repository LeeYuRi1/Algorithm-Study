package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1924 {
    public static void main(String[] args) throws IOException {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int days = 0;
        for (int i = 0; i < Integer.parseInt(line[0]) - 1; i++) {
            days += month[i];
        }
        days += Integer.parseInt(line[1]);

        System.out.println(date[days % 7]);
    }
}
