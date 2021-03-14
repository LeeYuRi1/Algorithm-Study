package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> word = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!word.contains(s)) word.add(s);
        }
        word.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return 1;
                }
            }
        });
        for (String s : word) {
            System.out.println(s);
        }
    }
}
