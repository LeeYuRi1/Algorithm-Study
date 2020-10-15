package algorithm.recursion;

// n개의 말을 놓을 때 동일 행, 열, 대각선상에 오지 않아야함
// 상태공간트리: 찾는 해를 포함하는 트리 - 해가 존재한다면 반드시 이 트리의 한 노드에 해당함
// backtracking: 상태공간트리를 깊이우선방식으로 탐색하여 해를 찾는 알고리즘
public class NQueensProblem {
    private static int N = 8;
    private static int[] cols = new int[N + 1];

    public static void main(String[] args) {
        queens(0);
    }

    private static boolean queens(int level) {
        if (!promising(level))
            return false;
        else if (level == N) {
            for (int i = 1; i <= N; i++)
                System.out.println("(" + i + ", " + cols[i] + ")");
            return true;
        }
        for (int i = 1; i <= N; i++) {
            cols[level + 1] = i;
            if (queens(level + 1))
                return true;
        }
        return false;
    }

    private static boolean promising(int level) {
        for (int i = 1; i < level; i++) {
            if (cols[i] == cols[level]) // 같은 열에 놓였는지 검사
                return false;
            else if (level - i == Math.abs(cols[level] - cols[i])) // 같은 대각선에 놓였는지 검사
                return false;
        }
        return true;
    }
}
