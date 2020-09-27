package java_data_structure.chapter2_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code2_InputFile {

    static Person1[] members = new Person1[100];
    static int n = 0;

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("src\\java_data_structure\\chapter2_1\\input.txt"));
            while (in.hasNext()) {
                String nm = in.next();
                String nb = in.next();
                members[n] = new Person1();
                members[n].name = nm;
                members[n].number = nb;
                n++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file");
        }

        for (int i = 0; i < n; i++)
            System.out.println(members[i].name + " " + members[i].number);
    }
}
