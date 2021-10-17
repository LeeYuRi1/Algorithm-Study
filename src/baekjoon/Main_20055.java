package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20055 {
    private static int n, k;
    private static int[] belt;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        k = Integer.parseInt(input1[1]);
        belt = new int[2 * n];
        robot = new boolean[n];
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(input2[i]);
        }

        int time = 0;
        while (true) {
            time++;
            if (move()) break;
        }
        System.out.println(time);
    }

    private static boolean move() {
        // belt[0]: 올리는 위치, belt[n-1]: 내리는 위치
        // 1. 벨트, 로봇 회전
        int temp = belt[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = temp;
        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[n - 1] = false;

        // 2. 로봇 이동
        for (int i = n - 1; i > 0; i--) {
            if (belt[i] > 0 && !robot[i] && robot[i - 1]) {
                robot[i - 1] = false;
                robot[i] = true;
                belt[i]--;
            }
        }
        robot[n - 1] = false;

        // 3. 올리는 위치 내구도가 0이 아니면 로봇 올림
        if (belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
        }
        // 4. 내구도가 0인 칸의 개수가 k개 이상이면 종료
        int sum = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (belt[i] == 0) sum++;
        }
        return sum >= k;
    }
}
