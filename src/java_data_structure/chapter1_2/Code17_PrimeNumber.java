package java_data_structure.chapter1_2;

// Code10 함수 분할: 1~100000사이의 모든 소수들을 찾아서 출력
public class Code17_PrimeNumber {
    public static void main(String[] args) {
        for (int n = 2; n <= 100000; n++) {
            if (isPrime(n))
                System.out.println(n);
        }
    }

    static boolean isPrime(int k) {
        if (k < 2)
            return false;
        for (int i = 2; i * i <= k; i++)
            if (k % i == 0)
                return false;
        return true;
    }
}