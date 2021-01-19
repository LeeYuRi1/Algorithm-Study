package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // StringBuilder 쓰지 않으면 시간 초과
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        while (n-- > 0) {
            a.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(a);
        for (int i : a) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}
