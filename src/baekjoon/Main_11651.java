package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Point_11651 implements Comparable<Point_11651> {
    int x, y;

    Point_11651(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point_11651 that) {
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

public class Main_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point_11651[] a = new Point_11651[n];
        for (int i = 0; i < n; i++) {
            String[] temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            a[i] = new Point_11651(x, y);
        }
        Arrays.sort(a, new Comparator<Point_11651>() {
            public int compare(Point_11651 p1, Point_11651 p2) {
                if (p1.y < p2.y) {
                    return -1;
                } else if (p1.y == p2.y) {
                    if (p1.x < p2.x) {
                        return -1;
                    } else if (p1.x == p2.x) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Point_11651 p : a) {
            sb.append(p.x + " " + p.y + "\n");
        }
        System.out.println(sb);
    }
}
