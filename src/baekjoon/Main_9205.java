package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_9205 {
    private static int N;
    private static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine()) + 2;
            points = new Point[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()) + 32768,
                        Integer.parseInt(st.nextToken()) + 32768);
            }
            sb.append(bfs() ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.offer(new Point(points[0].x, points[0].y));
        visited[0] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 1; i < N; i++) {
                if (visited[i]) continue;
                int d = Math.abs(cur.x - points[i].x) + Math.abs(cur.y - points[i].y);
                if (d <= 1000) {
                    queue.offer(new Point(points[i].x, points[i].y));
                    visited[i] = true;
                }
            }
        }
        return visited[N - 1];
    }
}
