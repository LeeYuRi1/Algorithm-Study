package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Shark {
    int s; // 속력
    int d; // 이동
    int z; // 크기

    public Shark(int s, int d, int z) {
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class Main_17143 {
    private static int r, c;
    private static Shark[][] area;
    private static int[] dx = {-1, 1, 0, 0}; // 위,아래,오른쪽,왼쪽
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        r = Integer.parseInt(input1[0]);
        c = Integer.parseInt(input1[1]);
        int m = Integer.parseInt(input1[2]);
        area = new Shark[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                area[i][j] = new Shark(0, 0, 0);
            }
        }
        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            area[Integer.parseInt(input2[0]) - 1][Integer.parseInt(input2[1]) - 1] = new Shark(Integer.parseInt(input2[2]), Integer.parseInt(input2[3]) - 1, Integer.parseInt(input2[4]));
        }

        int ans = 0;
        // 해당 열에 있는 상어중 제일 위에 있는 상어 잡음. 잡으면 사라짐
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (area[i][j].z > 0) {
                    ans += area[i][j].z;
                    area[i][j] = new Shark(0, 0, 0);
                    break;
                }
            }
            // 상어 이동 - 이동후 같은 칸에 여러마리면 크기 가장 큰 상어가 잡아먹음
            area = move();
        }
        System.out.println(ans);
    }

    private static Shark[][] move() {
        Shark[][] newArea = new Shark[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArea[i][j] = new Shark(0, 0, 0);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (area[i][j].z == 0) continue;
                //이동
                int nx = i;
                int ny = j;
                int nd = area[i][j].d;
                for (int k = 0; k < area[i][j].s; k++) {
                    if (nx == 0 && nd == 0) nd = 1;
                    if (nx == r - 1 && nd == 1) nd = 0;
                    if (ny == 0 && nd == 3) nd = 2;
                    if (ny == c - 1 && nd == 2) nd = 3;
                    nx += dx[nd];
                    ny += dy[nd];
                }
                //원래 위치의 크기와 비교해서 넣기
                area[i][j].d = nd;
                if (area[i][j].z > newArea[nx][ny].z) newArea[nx][ny] = area[i][j];
            }
        }
        return newArea;
    }
}
