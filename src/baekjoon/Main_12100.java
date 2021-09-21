package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12100 {
    private static int n, ans = 0;
    private static int[][] board;
    private static int[][] newBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        newBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        int[] arr = new int[5];
        backtracking(arr, 0);
        System.out.println(ans);
    }

    private static void backtracking(int[] arr, int depth) {
        if (depth == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }
            for (int i : arr) move(i);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[depth] = i;
            backtracking(arr, depth + 1);
        }
    }

    private static void move(int d) {
        Stack<Integer> stack = new Stack<>();
        boolean merge = false;
        switch (d) {
            case 0: //왼쪽
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (newBoard[i][j] != 0) {
                            if (stack.isEmpty()) stack.push(newBoard[i][j]);
                            else {
                                if (!merge && stack.peek() == newBoard[i][j]) {
                                    stack.push(stack.pop() + newBoard[i][j]);
                                    merge = true;
                                    continue;
                                } else {
                                    stack.push(newBoard[i][j]);
                                }
                            }
                            merge = false;
                        }
                    }
                    int size = stack.size();
                    for (int j = n - 1; j >= 0; j--) {
                        if (j < size) newBoard[i][j] = stack.pop();
                        else newBoard[i][j] = 0;
                    }
                }
                break;
            case 1: //오른쪽
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (newBoard[i][j] != 0) {
                            if (stack.isEmpty()) stack.push(newBoard[i][j]);
                            else {
                                if (!merge && stack.peek() == newBoard[i][j]) {
                                    stack.push(stack.pop() + newBoard[i][j]);
                                    merge = true;
                                    continue;
                                } else {
                                    stack.push(newBoard[i][j]);
                                }
                            }
                            merge = false;
                        }
                    }
                    int size = stack.size();
                    for (int j = 0; j < n; j++) {
                        if (n - j <= size) newBoard[i][j] = stack.pop();
                        else newBoard[i][j] = 0;
                    }
                }
                break;
            case 2: //위쪽
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < n; i++) {
                        if (newBoard[i][j] != 0) {
                            if (stack.isEmpty()) stack.push(newBoard[i][j]);
                            else {
                                if (!merge && stack.peek() == newBoard[i][j]) {
                                    stack.push(stack.pop() + newBoard[i][j]);
                                    merge = true;
                                    continue;
                                } else {
                                    stack.push(newBoard[i][j]);
                                }
                            }
                            merge = false;
                        }
                    }
                    int size = stack.size();
                    for (int i = n - 1; i >= 0; i--) {
                        if (i < size) newBoard[i][j] = stack.pop();
                        else newBoard[i][j] = 0;
                    }
                }
                break;
            case 3: //아래쪽
                for (int j = 0; j < n; j++) {
                    for (int i = n - 1; i >= 0; i--) {
                        if (newBoard[i][j] != 0) {
                            if (stack.isEmpty()) stack.push(newBoard[i][j]);
                            else {
                                if (!merge && stack.peek() == newBoard[i][j]) {
                                    stack.push(stack.pop() + newBoard[i][j]);
                                    merge = true;
                                    continue;
                                } else {
                                    stack.push(newBoard[i][j]);
                                }
                            }
                            merge = false;
                        }
                    }
                    int size = stack.size();
                    for (int i = 0; i < n; i++) {
                        if (n - i <= size) newBoard[i][j] = stack.pop();
                        else newBoard[i][j] = 0;
                    }
                }
                break;
        }
        findMax();
    }

    private static void findMax() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, newBoard[i][j]);
            }
        }
        ans = Math.max(ans, result);
    }
}
