package baekjoon;

import java.util.Scanner;

public class Main_10451 {

    static private int[] a;
    static private boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            a = new int[n + 1];
            check = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            int components = 0;
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    dfs(i);
                    components++;
                }
            }
            System.out.println(components);
        }
    }

    private static void dfs(int x) {
        if (check[x]) return;
        check[x] = true;
        dfs(a[x]); //다음 정점이 1개이므로 for문을 쓰지 않아도 됨
    }
}
