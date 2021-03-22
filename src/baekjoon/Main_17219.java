package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main_17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, String> map = new HashMap<>();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            map.put(s[0], s[1]);
        }
        while (m-- > 0) {
            bw.write(map.get(br.readLine()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
