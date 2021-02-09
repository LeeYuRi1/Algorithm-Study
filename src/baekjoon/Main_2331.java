package baekjoon;

import java.util.Scanner;

// 반복수열
// check[i] == 0 (아직 방문하지 않음)
// check[i] != 0 (방문 했는데 몇번째 방문인지)
public class Main_2331 {

    static private int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        check = new int[1000000];
        System.out.println(length(a, p, 1));
    }

    private static int length(int a, int p, int c) {
        if (check[a] != 0) return check[a]-1;
        check[a] = c;
        int b = next(a, p);
        return length(b, p, c+1);
    }

    private static int next(int a, int p) {
        int ans = 0;
        while (a>0) {
            ans += Math.pow(a%10, p);
            a /= 10;
        }
        return ans;
    }
}
