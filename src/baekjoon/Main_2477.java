package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int maxW = 0, maxH = 0;
        int[][] arr = new int[6][];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{d, l};
            if (d <= 2) maxW = Math.max(maxW, l);
            else maxH = Math.max(maxH, l);
        }
        int ans = (maxW * maxH) - getEmptyArea(arr);
        System.out.println(ans * k);
    }

    private static int getEmptyArea(int[][] arr) {
        HashSet<String> set = new HashSet<>();
        String[] str = {"13", "41", "24", "32"};
        for (int i = 0; i < 4; i++) {
            set.add(str[i]);
        }
        for (int i = 0; i < 6; i++) {
            String num = arr[i][0] + "" + arr[(i + 1) % 6][0];
            if (set.contains(num)) return arr[i][1] * arr[(i + 1) % 6][1];
        }
        return 0;
    }
}
