package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 소요 시간 : 151 ms
// 메모리 사용량 : 27,392 kb
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
                        d = mapIntD.get(area[i][j]);
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
            sb.append("#" + testCase + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (area[i][j] == '0') area[i][j] = mapCharD.get(d);
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
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || area[nx][ny] == '#') break;
                if (area[nx][ny] == '*') {
                    area[nx][ny] = '.';
                    break;
                }
            }
        } else { // U D L R - 전차 방향 바꾸고 한칸 앞이 평지라면 그 칸으로 이동
            d = mapIntD.get(c);
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= h || ny < 0 || ny >= w || area[nx][ny] != '.') return;
            area[x][y] = '.';
            x = nx;
            y = ny;
            area[x][y] = '0'; // 전차 모양 임의로 0 - 마지막에 바꾸기
        }
    }
}
