package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashSet hashSet = new HashSet(); // 순서 상관 없으므로 hastset

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            hashSet.add(num);
        }

        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (hashSet.contains(num))
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}
