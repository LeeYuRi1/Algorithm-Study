package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11023 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < line.length; i++) {
            sum += Integer.parseInt(line[i]);
        }
        System.out.println(sum);
    }

    //StringTokenizer 사용
    public static void answer() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line); // 구분자 지정 생략하면 공백이나 탭이 기본 구분자
        int sum = 0;
        while (st.hasMoreTokens()) { //hasMoreTokens(): StringTokenizer객체에서 다음에 읽어들일 token이 있으면 true, 없으면 false를 return
            sum += Integer.valueOf(st.nextToken()); //nextToken(): StringTokenizer객체에서 다음 토큰을 읽어옴
        }
        System.out.println(sum);
    }
}
