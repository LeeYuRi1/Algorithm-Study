package template.backtracking;

// N과 M (1)
public class Backtracking_1 {
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int[] arr = new int[m];
        boolean[] visited = new boolean[n + 1]; // 중복 없이 구할 때 필요
        backtracking(arr, visited, n, m, 0);
    }

    private static void backtracking(int[] arr, boolean[] visited, int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backtracking(arr, visited, n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}
