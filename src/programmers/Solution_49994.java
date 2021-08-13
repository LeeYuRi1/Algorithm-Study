package programmers;

import java.util.ArrayList;

// 방문 길이
class Path_49994 {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Path_49994(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public boolean equals(Path_49994 path) {
        if (startX == path.startX && startY == path.startY && endX == path.endX && endY == path.endY) return true;
        if (startX == path.endX && startY == path.endY && endX == path.startX && endY == path.startY) return true;
        return false;
    }
}

public class Solution_49994 {
    private static int x = 0;
    private static int y = 0;
    private static int answer = 0;
    private static ArrayList<Path_49994> pathList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    public static int solution(String dirs) {
        for (int i = 0; i < dirs.length(); i++) {
            go(dirs.charAt(i));
        }
        return answer;
    }

    private static void go(char d) {
        switch (d) {
            case 'U':
                answer += check(0, 1);
                break;
            case 'D':
                answer += check(0, -1);
                break;
            case 'R':
                answer += check(1, 0);
                break;
            case 'L':
                answer += check(-1, 0);
                break;
        }
    }

    private static int check(int dx, int dy) {
        int nx = x + dx;
        int ny = y + dy;
        if (nx < -5 || nx > 5 || ny < -5 || ny > 5) return 0;
        Path_49994 path1 = new Path_49994(x, y, nx, ny);
        x = nx;
        y = ny;
        for (Path_49994 path : pathList) {
            if (path.equals(path1)) return 0;
        }
        pathList.add(path1);
        return 1;
    }
}
