package java_data_structure.chapter1_1;

import java.util.Scanner;

//0개 이상의 연속된 정수들을 더하여 얻을 수 있는 최대값
public class Code12_MaxContinuation {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++)
            data[i] = kb.nextInt();
        kb.close();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) { // j=i 시작점과 끝점이 같음(길이가 1)
                //data[i]에서 data[j]까지 합을 구한 다음 만약 그 sum이 현재 최대 sum보다 크면 새로운 sum
                sum += data[j];
                if (sum > max)
                    max = sum;
            }
        }
        System.out.println(max);
    }
}
