package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Doc {
    public int index;
    public int doc;

    public Doc(int index, int doc) {
        this.index = index;
        this.doc = doc;
    }
}

public class Main_1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[1]);
            String[] input2 = br.readLine().split(" ");
            System.out.println(find(input2, m));
        }
    }

    private static int find(String[] array, int n) {
        if (array.length == 1) return 1;
        int answer = 0;
        Queue<Doc> queue = new LinkedList<>();
        Queue<Integer> sortPriorities = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            queue.offer(new Doc(i, Integer.parseInt(array[i])));
        }
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            sortPriorities.offer(Integer.parseInt(array[i]));
        }

        while (!queue.isEmpty()) {
            Doc poll = queue.poll();
            if (poll.doc == sortPriorities.peek()) {
                answer++;
                sortPriorities.poll();
                if (poll.index == n) break;
            } else {
                queue.offer(poll);
            }
        }
        return answer;
    }
}
