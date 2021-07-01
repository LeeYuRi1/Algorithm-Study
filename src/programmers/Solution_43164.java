package programmers;

import java.util.ArrayList;
import java.util.Collections;

// 여행경로
public class Solution_43164 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        System.out.println(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
    }

    public static String[] solution(String[][] tickets) {
        ArrayList<String> ans = new ArrayList<>();
        String[] path = new String[tickets.length];
        boolean[] visit = new boolean[tickets.length];
        dfs(ans, tickets, visit, path, "ICN", 0);
        Collections.sort(ans);
        return ans.get(0).split(" ");
    }

    private static void dfs(ArrayList<String> ans, String[][] tickets, boolean[] visit, String[] path, String start, int index) {
        if (index == tickets.length) {
            String result = "ICN ";
            for (String i : path) result += i + " ";
            ans.add(result);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && tickets[i][0].equals(start)) {
                visit[i] = true;
                path[index] = tickets[i][1];
                dfs(ans, tickets, visit, path, tickets[i][1], index + 1);
                visit[i] = false;
            }
        }
    }
}
