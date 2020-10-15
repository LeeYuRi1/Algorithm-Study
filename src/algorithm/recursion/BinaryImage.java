package algorithm.recursion;

// 각 픽셀은 background pixel, image pixel로 이루어짐
// 서로 연결(상하좌우, 대각방향)된 image pixel들의 집합을 blob이라 부름
// (x.y)가 포함된 blob의 크기 출력. 속하지 않는 경우는 0
public class BinaryImage {
    private static int N = 8;
    private static int[][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1}
    };

    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR = 1;
    private static int ALREADY_COUNTED = 2;

    public static void main(String[] args) {
        System.out.println(countCells(3, 5));
    }

    private static int countCells(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return 0;
        else if (grid[x][y] != IMAGE_COLOR)
            return 0;
        else {
            grid[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x - 1, y + 1) + countCells(x, y + 1)
                    + countCells(x + 1, y + 1) + countCells(x - 1, y)
                    + countCells(x + 1, y) + countCells(x - 1, y - 1)
                    + countCells(x, y - 1) + countCells(x + 1, y - 1);
        }
    }
}
