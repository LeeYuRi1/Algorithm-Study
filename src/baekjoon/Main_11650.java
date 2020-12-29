package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Point1 implements Comparable<Point1> {
    int x, y;

    Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point1 that) {
        if (this.x < that.x) {
            return -1;
        } else if (this.x == that.x) {
            if (this.y < that.y) {
                return -1;
            } else if (this.y == that.y) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Main_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point1[] a = new Point1[n];
        for (int i = 0; i < n; i++) {
            String[] temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            a[i] = new Point1(x, y);
        }
        Arrays.sort(a, new Comparator<Point1>() {
            public int compare(Point1 p1, Point1 p2) {
                return p1.compareTo(p2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Point1 p : a) {
            sb.append(p.x + " " + p.y + "\n");
        }
        System.out.println(sb);
    }
}