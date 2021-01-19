package baekjoon;

import java.io.*;

//메모리초과, 시간초과 때문에 BufferedReader, BufferedWriter 사용
public class Main_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[10001];
        for (int i = 0; i < n; i++) {
            a[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i <= 10000; i++) {
            if (a[i] > 0) {
                for (int j = 0; j < a[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}
