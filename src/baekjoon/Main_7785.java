package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();
            if (record.equals("enter")) set.add(name);
            else set.remove(name);
        }
        List<String> ans = new ArrayList<>(set);
        ans.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : ans) sb.append(s).append("\n");
        System.out.println(sb);
    }
}
