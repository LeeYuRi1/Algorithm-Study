package baekjoon;

import java.util.Scanner;

public class Main_11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        String result = "";

        while (n > 0) {
            int r = n % b;
            if (r >= 10)
                result += (char) (r - 10 + (int) 'A');
            else
                result += (char) (r + (int) '0');
            n = n / b;
        }

        for (int i = result.length() - 1; i >= 0; i--)
            System.out.print(result.charAt(i));
    }
}
