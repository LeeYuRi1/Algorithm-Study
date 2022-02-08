package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 소요 시간 : 131 ms
// 메모리 사용량 : 25,808 kb
public class Solution_1225 {
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            createCode();
            sb.append("#").append(tc).append(" ");
            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void createCode() {
        while (true) {
            for (int i = 1; i <= 5; i++) {
                int poll = queue.poll() - i;
                if (poll <= 0) {
                    queue.offer(0);
                    return;
                }
                queue.offer(poll);
            }
        }
    }
}
