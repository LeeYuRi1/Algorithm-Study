package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nList.add(Integer.parseInt(s[i]));
        }
        Collections.sort(nList);

        int m = Integer.parseInt(br.readLine());
        String[] mList = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (find(nList, Integer.parseInt(mList[i]))) System.out.println(1);
            else System.out.println(0);
        }
    }

    private static boolean find(List<Integer> list, int n) {
        int first = 0;
        int last = list.size() - 1;
        int mid = 0;
        while (first <= last) {
            mid = (first + last) / 2;
            if (n == list.get(mid)) return true;
            if (n < list.get(mid)) last = mid - 1;
            else first = mid + 1;
        }
        return false;
    }
}
