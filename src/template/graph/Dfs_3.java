package template.graph;

public class Dfs_3 {
    public static void main(String[] args) {
        int n = 7;
        int[] a = new int[n + 1];
        a[1] = 3;
        a[2] = 1;
        a[3] = 3;
        a[4] = 7;
        a[5] = 3;
        a[6] = 4;
        a[7] = 6;
        int[] check = new int[n + 1]; // 몇번째 방문인지 표시
        int[] start = new int[n + 1]; // 시작 정점
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                count += dfs(a, check, start, i, 1, i);
            }
        }
        // 사이클에 속한 정점의 수
        System.out.println(count);
    }

    private static int dfs(int[] a, int[] check, int[] start, int x, int circleNum, int startNum) {
        if (check[x] != 0) { // 방문했었으면
            if (startNum != start[x]) return 0; //시작 정점과 다르면 사이클이 아님
            return circleNum - check[x]; // 같으면 사이클의 장점 개수 반환
        }
        check[x] = circleNum;
        start[x] = startNum;
        return dfs(a, check, start, a[x], circleNum + 1, startNum);
    }
}
