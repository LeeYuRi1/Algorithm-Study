package java_data_structure.chapter1_3;


import java.io.*;
import java.util.Scanner;

// 입력으로 텍스트 파일을 읽어서 모든 단어들의 목록을 만들고 각 단어가 등장하는 횟수를 셈
// 단어 개수는 100000개 이하라고 가정
// 사용자가 요청하면 단어 목록을 하나의 파일로 저장. 검색하면 그 단어가 텍스트파일에 몇번 등장하는지 출력
public class Code22_indexMaker {

    static String[] words = new String[100000];
    static int[] count = new int[100000];
    static int n = 0; // 단어의 개수

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        // 대화식 프로그램
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("read")) {
                String fileName = kb.next();
                makeIndex(fileName);
            } else if (command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if (index > -1)
                    System.out.println("The word " + words[index] + " appears" + count[index] + " times.");
                else
                    System.out.println("The word " + str + " does not appear.");
            } else if (command.equals("saveas")) {
                String fileName = kb.next();
                saveAs(fileName);
            } else if (command.equals("exit")) {
                break;
            }
        }
        kb.close();

        for (int i = 0; i < n; i++) {
            System.out.println(words[i] + " " + count[i]);
        }
    }

    static void makeIndex(String fileName) {
        try {
            Scanner inFile = new Scanner(new File(fileName));
            while (inFile.hasNext()) { //file의 끝에 도달했는지 검사
                String str = inFile.next();
                addWord(str);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }

    }

    static void addWord(String str) {
        int index = findWord(str);
        if (index != -1) { //found (words[index] == str)
            count[index]++;
        } else { // not found
            words[n] = str;
            count[n] = 1;
            n++;
        }
    }

    // 이미 단어 목록에 포함되어 있는지 검사
    static int findWord(String str) {
        for (int i = 0; i < n; i++)
            if (words[i].equalsIgnoreCase(str))
                return i;
        return -1;
    }

    static void saveAs(String fileName) {
        PrintWriter outFile;
        try {
            outFile = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < n; i++)
                outFile.println(words[i] + " " + count[i]);
            outFile.close();
        } catch (IOException e) {
            System.out.println("Save failed");
            return;
        }
    }

}

// 실행 예시
// read src\java_data_structure\chapter1_3\sample.txt
// find aaa
// saveas output.txt