package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 소요 시간 : 104 ms
// 메모리 사용량 : 19,616 kb
public class Solution_1228 {
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            list = new LinkedList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            br.readLine();
            st = new StringTokenizer(br.readLine(), "I");
            while (st.hasMoreTokens()) {
                getCode(new StringTokenizer(st.nextToken()));
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void getCode(StringTokenizer st) {
        int index = Integer.parseInt(st.nextToken());
        st.nextToken();
        while (st.hasMoreTokens()) {
            list.add(index++, Integer.parseInt(st.nextToken()));
        }
    }
}
