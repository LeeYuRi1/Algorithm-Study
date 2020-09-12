package java_data_structure.chapter1_3;

import java.io.*;
import java.util.Scanner;

// Code22의 문제점
// 특수기호가 단어에 포함, 숫자가 단어로 취급, 대소문자가 다른 단어로 취급, 단어 정렬 되도록
public class Code23_IndexMaker_Improve {

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
                String trimmed = trimming(str);
                if (trimmed != null) {
                    String t = trimmed.toLowerCase();
                    addWord(t);
                }
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
            // 단어 정렬: 항상 정렬된 상태를 유지하도록 삽입
            int i = n - 1;
            while (i >= 0 && words[i].compareTo(str) > 0) {
                words[i + 1] = words[i];
                count[i + 1] = count[i];
                i--;
            }
            words[i+1] = str;
            count[i+1] = 1;
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

    // 단어의 앞뒤에 붙은 특수문자 제거하기
    static String trimming(String str) {
        int i = 0, j = str.length() - 1;

        while (i < str.length() && !Character.isLetter(str.charAt(i))) // i번째 문자가 알파벳이 아닌 동안 돌음
            i++;

        while (j > 0 && !Character.isLetter(str.charAt(j))) // i번째 문자가 알파벳이 아닌 동안 돌음
            j--;

        if (i > j)
            return null;
        return str.substring(i, j + 1); // [ )
    }

}
