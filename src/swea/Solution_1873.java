package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 소요 시간 : 144 ms
// 메모리 사용량 : 24,136 kb
public class Solution_1873 {
    private static char[][] area;
    private static HashMap<Character, Integer> mapIntD; // 방향 문자로 d값을 찾음
    private static HashMap<Integer, Character> mapCharD; // d값으로 방향 문자를 찾음
    private static int h, w, x, y, d; // x,y: 현재 위치, d: 현재 방향
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        mapIntD = new HashMap<>();
        mapCharD = new HashMap<>();
        char[] chars1 = {'^', 'v', '<', '>'};
        char[] chars2 = {'U', 'D', 'L', 'R'};
        for (int i = 0; i < 4; i++) {
            mapIntD.put(chars1[i], i);
            mapIntD.put(chars2[i], i);
            mapCharD.put(i, chars1[i]);
        }
        // 입력
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= t; testCase++) {
            String[] input1 = br.readLine().split(" ");
            h = Integer.parseInt(input1[0]);
            w = Integer.parseInt(input1[1]);
            area = new char[h][w];
            for (int i = 0; i < h; i++) {
                String[] input2 = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    area[i][j] = input2[j].charAt(0);
                    if (mapIntD.containsKey(area[i][j])) {
                        x = i;
                        y = j;
                        d = mapIntD.get(area[x][y]);
                        area[x][y] = '.';
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            // 로직
            for (int i = 0; i < n; i++) {
                move(input.charAt(i));
            }
            // 결과
            area[x][y] = mapCharD.get(d);
            sb.append("#" + testCase + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(area[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void move(char c) {
        if (c == 'S') { // S 현재 바라보고 있는 방향으로 포탄을 발사 - 벽에 부딪히면 소멸, 벽이 벽돌벽이면 평지로 바꿈
            int nx = x;
            int ny = y;
            while (checkRange(nx, ny)) {
                if (area[nx][ny] == '#') break;
                if (area[nx][ny] == '*') {
                    area[nx][ny] = '.';
                    break;
                }
                nx += dx[d];
                ny += dy[d];
            }
        } else { // U D L R - 전차 방향 바꾸고 한칸 앞이 평지라면 그 칸으로 이동
            d = mapIntD.get(c);
            if (!checkRange(x + dx[d], y + dy[d]) || area[x + dx[d]][y + dy[d]] != '.') return;
            x += dx[d];
            y += dy[d];
        }
    }

    private static boolean checkRange(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }
}