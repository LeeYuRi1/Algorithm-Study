package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        if (m != 0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                list.add(Integer.parseInt(input[i]));
            }
        }
        int ans = Math.abs(n - 100);
        for (int i = 0; i <= 1000000; i++) {
            boolean check = checkButton(list, i);
            if (check) ans = Math.min(ans, (i + "").length() + Math.abs(n - i));
        }
        System.out.println(ans);
    }

    private static boolean checkButton(ArrayList<Integer> list, int num) {
        if (num == 0) return !list.contains(num);
        while (num > 0) {
            int x = num % 10;
            if (list.contains(x)) return false;
            num /= 10;
        }
        return true;
    }
}
