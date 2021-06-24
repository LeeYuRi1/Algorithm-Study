package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_15686 {
    private static ArrayList<int[]> house;
    private static ArrayList<int[]> chicken;
    private static int[][] arr;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(s2[j]) == 1) house.add(new int[]{i, j});
                if (Integer.parseInt(s2[j]) == 2) chicken.add(new int[]{i, j});
            }
        }
        arr = new int[m][2];
        boolean[] visit = new boolean[chicken.size()];
        backtracking(visit, 0, 0, m);
        System.out.println(ans);
    }

    private static void backtracking(boolean[] visit, int start, int index, int m) {
        if (index == m) {
            minDistance();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[index][0] = chicken.get(i)[0];
                arr[index][1] = chicken.get(i)[1];
                backtracking(visit, i + 1, index + 1, m);
                visit[i] = false;
            }
        }
    }

    private static void minDistance() {
        int result = 0;
        for (int i = 0; i < house.size(); i++) {
            int min = Integer.MAX_VALUE;
            int[] h = house.get(i);
            for (int j = 0; j < arr.length; j++) {
                min = Math.min(min, Math.abs(h[0] - arr[j][0]) + Math.abs(h[1] - arr[j][1]));
            }
            result += min;
        }
        ans = Math.min(ans, result);
    }
}
