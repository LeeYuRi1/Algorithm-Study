package java_data_structure.chapter1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 2차원 배열에서 소수 찾기
// 입력으로 n*n개의 음이 아닌 한자리 정수가 주어짐.
// 가로, 세로, 대각선의 8방향으로 연속된 숫자들을 합쳐서 만들 수 있는 모든 소수들을 찾아서 나열
// 중복된 수를 출력해도 상관없음
public class Code21_PrimeNumberInTwoDimensionalArray {
    static int n;
    static int[][] grid;

    public static void main(String[] args) {

        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("data.txt"));
            n = inFile.nextInt();
            grid = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    grid[i][j] = inFile.nextInt();
            inFile.close();

            // 하나의 수열은 시작점, 방향, 길이에 의해서 정의
            // 방향을 0~7번까지의 수로 표현
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) { // 모든 시작점
                    for (int dir = 0; dir < 8; dir++) { // 진행 방향
                        for (int len = 1; len <= n; len++) { // 길이
                            int value = computeValue(x, y, dir, len);
                            if (value != -1 && isPrime(value))
                                System.out.println(value);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 수열을 정수로 환산
    public static int computeValue(int x, int y, int dir, int len) {
        int value = 0;
        for (int i = 0; i < len; i++) {
            int digit = getDigit(x, y, dir, i);
            if (digit == -1)
                return -1;
            value = value * 10 + digit;
        }
        return value;
    }

    //좌표 x,y에서 dir 방향으로 i칸 떨어진 자리에 저장되어있는 숫자를 읽어주는 함수
    public static int getDigit(int x, int y, int dir, int k) {
        int newX = x, newY = y;
        switch (dir) {
            case 0: newY -= k; break; // 위쪽: y감소 (y가 아래로 갈수록 +)
            case 1: newX += k; newY -= k; break; // 오른쪽 위 대각선
            case 2: newX += k; break; // 오른쪽
            case 3: newX += k; newY += k; break; // 오른쪽 아래 대각선
            case 4: newY += k; // 아래쪽
            case 5: newX -= k; newY += k; break; // 왼쪽 아래 대각선
            case 6: newX -= k; break; // 왼쪽
            case 7: newX -= k; newY -= k; break; // 왼쪽 위 대각선
        }
        if (newX < 0 || newX >= n || newY < 0 || newY >= n)
            return -1;
        return grid[newX][newY];
    }

    // getDigit의 다른 방법
    public static int getDigitFix(int x, int y, int dir, int k) {
        // 임의의 위치에서 dir 방향으로 한 칸 움직였을 때 좌표값의 증감분
        int[] offsetX = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] offsetY = {-1, -1, 0, 1, 1, 1, 0, -1};

        int newX = x + k * offsetX[dir];
        int newY = y + k * offsetY[dir];
        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length)
            return -1;
        else
            return grid[newX][newY];
    }

    // 소수 검사
    public static boolean isPrime(int k) {
        if (k < 2)
            return false;
        for (int i = 2; i * i <= k; i++)
            if (k % i == 0)
                return false;
        return true;
    }

}