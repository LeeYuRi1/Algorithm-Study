package baekjoon;

import java.util.Scanner;

public class Main_1297 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diagonal = sc.nextInt();
        int heightRate = sc.nextInt();
        int widthRate = sc.nextInt();

        double diagonalRate = Math.sqrt((double) (diagonal * diagonal) / (heightRate * heightRate + widthRate * widthRate));

        System.out.println((int) Math.floor(heightRate * diagonalRate));
        System.out.println((int) Math.floor(widthRate * diagonalRate));
    }
}
