package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int zero = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) plus.add(num);
            else if (num < 0) minus.add(num);
            else zero++;
        }
        Collections.sort(plus);
        Collections.sort(minus, Collections.reverseOrder());

        int resultPlus = 0;
        int start = 0;
        if (plus.size() % 2 != 0) {
            resultPlus += plus.get(0);
            start = 1;
        }
        for (int i = start; i < plus.size(); i += 2) {
            if (plus.get(i) * plus.get(i + 1) > plus.get(i) + plus.get(i + 1)) {
                resultPlus += plus.get(i) * plus.get(i + 1);
            } else {
                resultPlus += plus.get(i) + plus.get(i + 1);
            }
        }

        int resultMinus = 0;
        start = 0;
        if (minus.size() % 2 != 0) {
            if (zero == 0) resultMinus += minus.get(0);
            start = 1;
        }
        for (int i = start; i < minus.size(); i += 2) {
            if (minus.get(i) * minus.get(i + 1) > minus.get(i) + minus.get(i + 1)) {
                resultMinus += minus.get(i) * minus.get(i + 1);
            } else {
                resultMinus += minus.get(i) + minus.get(i + 1);
            }
        }
        System.out.println(resultPlus + resultMinus);
    }
}
