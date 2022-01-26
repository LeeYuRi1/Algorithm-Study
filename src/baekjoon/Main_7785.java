package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            if (input[1].equals("enter")) set.add(input[0]);
            else set.remove(input[0]);
        }
        List<String> ans = new ArrayList<>(set);
        ans.sort(Collections.reverseOrder());
        for (String s : ans) sb.append(s).append("\n");
        System.out.println(sb);
    }
}