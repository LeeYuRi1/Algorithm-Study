package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Body {
    int x;
    int y;

    Body(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Body> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Body(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y) {
                    rank++;
                }
            }
            sb.append(rank + " ");
        }
        System.out.println(sb);
    }
}
