package programmers;

import java.util.Arrays;

// 여행경로
public class Solution_43164 {
    private static boolean[] visited;
    private static String[] cur;
    private static String ans = "z";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        cur = new String[tickets.length];
        dfs(tickets, 0, "ICN");
        return ans.split(" ");
    }

    private static void dfs(String[][] tickets, int depth, String start) {
        if (depth == tickets.length) {
            String s = "ICN ";
            for (String i : cur) s += i + " ";
            if (s.compareTo(ans) < 0) ans = s; // 사전순으로 앞서면 넣어주기
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!tickets[i][0].equals(start) || visited[i]) continue;
            visited[i] = true;
            cur[depth] = tickets[i][1];
            dfs(tickets, depth + 1, tickets[i][1]);
            visited[i] = false;
        }
    }
}
