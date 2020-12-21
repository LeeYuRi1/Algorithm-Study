package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet hashSet = new HashSet();

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            if (input[1].equals("enter")) {
                hashSet.add(input[0]);
            } else if (input[1].equals("leave")) {
                hashSet.remove(input[0]);
            }
        }

        List<String> nameList = new ArrayList<>(hashSet);
        Collections.sort(nameList, Collections.reverseOrder());

        for (int i = 0; i <= nameList.size() - 1; i++) {
            System.out.println(nameList.get(i));
        }
    }
}
