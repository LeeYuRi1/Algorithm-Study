package java_data_structure.chapter1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// input.txt 파일로부터 이름, 전화번호 쌍을 입력받아 배열에 저장하고 출력
public class Code19_InputFile {
    public static void main(String[] args) {

        String[] name = new String[1000]; // 배열의 크기를 충분히 크게 잡기
        String[] number = new String[1000];
        int n = 0; // 사람 수

        try {
            Scanner inFile = new Scanner(new File("input.txt"));
            //데이터의 개수를 몰라서 for문 사용 불가
            while (inFile.hasNext()) { // 더 읽을 것이 있으면 true, 없으면 false (detect end of File)
                name[n] = inFile.next();
                number[n] = inFile.next();
                n++;
            }
            inFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("No file");
            System.exit(1); // 프로그램 종료(0: 정상적인 종료, 1: 비정상적인 오류로 종료)
        }

        for (int i = 0; i < n; i++)
            System.out.println(name[i] + ": " + number[i]);
    }
}