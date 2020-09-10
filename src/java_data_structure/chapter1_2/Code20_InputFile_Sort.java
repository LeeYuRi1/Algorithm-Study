package java_data_structure.chapter1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// input.txt 파일로부터 이름, 전화번호 쌍을 입력받은 후 이름의 알파벳 순서로 정렬하여 출력
public class Code20_InputFile_Sort {

    static String[] name = new String[1000];
    static String[] number = new String[1000];
    static int n = 0;

    public static void main(String[] args) {
        try {
            Scanner inFile = new Scanner(new File("input.txt"));
            while (inFile.hasNext()) {
                name[n] = inFile.next();
                number[n] = inFile.next();
                n++;
            }
            inFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("No file");
            System.exit(1);
        }

        bubbleSort();

        for (int i = 0; i < n; i++)
            System.out.println(name[i] + ": " + number[i]);
    }

    static void bubbleSort() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 문자열 간의 사전식 순서 검사: str1.compareTo(str2) - str이 빠르면(작으면) 음수, 같으면 0(== equals), 크면 양수 반환
                // 대소문자 구분없이 비교할 경우 compareToIgnoreCase 사용
                if (name[j].compareTo(name[j + 1]) > 0) { // name[j]가 name[j+1]보다 크면(사전식 순서로 뒤쪽이면)
                    String tmp = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = tmp;

                    tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }
}