package baekjoon;

import java.util.Scanner;

public class Main_3003 {
    public static void main(String[] args) {
        int[] pieceNum = new int[]{1, 1, 2, 2, 2, 8};
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < pieceNum.length; i++) {
            System.out.print(pieceNum[i] - sc.nextInt() + " ");
        }
    }
}
