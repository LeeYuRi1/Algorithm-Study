package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Pair_15686 {
    int x;
    int y;

    public Pair_15686(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_15686 {
    private static int m, ans = Integer.MAX_VALUE;
    private static int[][] city;
    private static List<Pair_15686> house;
    private static List<Pair_15686> chicken;
    private static Pair_15686[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        city = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(input2[j]);
                if (city[i][j] == 1) house.add(new Pair_15686(i, j));
                if (city[i][j] == 2) chicken.add(new Pair_15686(i, j));
            }
        }
        arr = new Pair_15686[m];
        visited = new boolean[chicken.size()];
        selectChicken(0, 0);
        System.out.println(ans);
    }

    private static void selectChicken(int depth, int start) {
        if (depth == m) {
            minDistance();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = chicken.get(i);
                selectChicken(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    private static void minDistance() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                min = Math.min(min, Math.abs(house.get(i).x - arr[j].x) + Math.abs(house.get(i).y - arr[j].y));
            }
            sum += min;
        }
        ans = Math.min(ans, sum);
    }
}
