package template.backtracking;

// N과 M (3)
public class Backtracking_3 {
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int[] arr = new int[m];
        backtracking(arr, n, m, 0);
    }

    private static void backtracking(int[] arr, int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) { // 중복 허용하므로 1부터 시작
            arr[depth] = i;
            backtracking(arr, n, m, depth + 1);
        }
    }
}
