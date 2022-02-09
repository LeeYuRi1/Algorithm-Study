package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 소요 시간 : 612 ms
// 메모리 사용량 : 108260 kb
class Top {
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Main_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) { // 스택에서 수신할 수 있는 탑이 있을 때까지 찾음
                if (stack.peek().height < h) { // 낮아서 수신할 수 없다면 pop
                    stack.pop();
                } else { // 수신할 수 있다면 출력하고 멈춤. 다음에 또 수신할 수 있으니까 pop 하지 않음
                    sb.append(stack.peek().index).append(" ");
                    break;
                }
            }
            // 스택이 비어있다면 수신할 수 있는 탑이 없는 것 (처음이거나 스택에서 수신할 탑을 못찾은 경우)
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            stack.push(new Top(i + 1, h));
        }
        System.out.println(sb);
    }
}
