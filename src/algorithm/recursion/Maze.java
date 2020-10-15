package algorithm.recursion;

// (x,y)에서 출구로 가는 미로찾기
public class Maze {
    private static int N = 8;
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };

    private static final int PATHWAY_COLOR = 0; // 통로
    private static final int WALL_COLOR = 1; // 벽
    private static final int BLOCKED_COLOR = 2; // 이미 방문했지만 출구까지 가는 통로가 없음
    private static final int PATH_COLOR = 3; // 이미 방문했지만 출구까지 가는 통로가 있는지 모름

    public static void main(String[] args) {
        printMaze();
        findMazePath(0, 0);
        System.out.println();
        printMaze();
    }

    private static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) //좌표가 유효한 범위인지 검사
            return false;
        else if (maze[x][y] != PATHWAY_COLOR)
            return false;
        else if (x == N - 1 && y == N - 1) { //출구일때
            maze[x][y] = PATH_COLOR;
            return true;
        } else {
            maze[x][y] = PATH_COLOR;
            if (findMazePath(x - 1, y) || findMazePath(x, y + 1)
                    || findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
                return true;
            }
            maze[x][y] = BLOCKED_COLOR;
            return false;
        }
    }

    private static void printMaze() {
        for (int i = 0; i < N; i++) {
            System.out.print("{");
            for (int j = 0; j < N; j++) {
                System.out.print(maze[i][j]);
                if (j != N - 1)
                    System.out.print(", ");
            }
            System.out.println("}");
        }
    }

}