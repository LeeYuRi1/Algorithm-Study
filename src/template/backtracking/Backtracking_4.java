package template.backtracking;

// N과 M (4)
public class Backtracking_4 {
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int[] arr = new int[m];
        backtracking(arr, n, m, 0, 1);
    }

    private static void backtracking(int[] arr, int n, int m, int depth, int start) {
        if (depth == m) {
            for (int i : arr) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            backtracking(arr, n, m, depth + 1, i); // 비내림차순이므로 i부터
        }
    }
}
