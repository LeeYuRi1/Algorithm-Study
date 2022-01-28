package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        while (m-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            int index = list.indexOf(num);
            if (index <= list.size() / 2) { // 2
                while (num != list.getFirst()) {
                    list.addLast(list.removeFirst());
                    ans++;
                }
            } else { // 3
                while (num != list.get(0)) {
                    list.addFirst(list.removeLast());
                    ans++;
                }
            }
            list.removeFirst(); // 1
        }
        System.out.println(ans);
    }
}
