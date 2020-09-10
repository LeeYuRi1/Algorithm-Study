package java_data_structure.chapter1_1;

import java.util.Scanner;

// 한자리 정수들 입력받아서 1개 이상 연속된 정수들을 붙여서 얻을 수 있는 소수들 중 최대값
public class Code13_MaxPrime {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++)
            data[i] = kb.nextInt();
        kb.close();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //data[i]에서 data[j]까지 정수로 환산. 소수인지 검사. 소수면 현재까지 알고있는 최대값과 비교
                int val = 0;
                for (int k = i; k <= j; k++)
                    val = val * 10 + data[k];

                boolean isPrime = true;
                for (int k = 2; k * k <= val && isPrime; k++) {
                    if (val % k == 0)
                        isPrime = false;
                }

                if (isPrime && val > 1 && val > max) // 1은 소수가 아니므로 val > 1 조건 추가
                    max = val;
            }
        }
        if (max > 0)
            System.out.println(max);
        else
            System.out.println("No prime number");
    }
}

