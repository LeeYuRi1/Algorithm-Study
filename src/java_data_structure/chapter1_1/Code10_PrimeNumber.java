package java_data_structure.chapter1_1;

// 1~100000사이의 모든 소수들을 찾아서 출력
public class Code10_PrimeNumber {
    public static void main(String[] args) {
        for (int n = 2; n < 100000; n++) {
            boolean isPrime = true;

            // n의 약수가 n/2보다 클 수 없음 (root(n)까지만 해도 충분 sqrt(n): 루트n보다 큰 약수가 있다면 루트n보다 작은 약수도 존재함)
            // i <= 루트n은 i의 제곱 <= n
            for (int i = 2; i * i <= n && isPrime; i++) {
                if (n % i == 0) {// not prime 소수가 아니면 false
                    isPrime = false;
//                break; //break 대신 for문 조건에 할수있음
                }
            }
            if (isPrime)
                System.out.println(n); //소수이면 출력
        }
    }
}
