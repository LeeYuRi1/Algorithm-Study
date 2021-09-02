package template.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    public static void main(String[] args) {
        int[][] item = {{60, 10}, {100, 20}, {120, 30}}; // 가치, 무게
        int limit = 50; // 배낭의 제한 무게
        // 무게 대비 가치순으로 정렬
        Arrays.sort(item, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int v1 = o1[0] / o1[1];
                int v2 = o2[0] / o2[1];
                return v2 - v1;
            }
        });

        int result = 0;
        for (int i = 0; i < item.length; i++) {
            if (limit <= 0) break;
            int[] cur = item[i];
            if (limit >= cur[1]) {// 물건의 무게가 제한 이하일 경우
                limit -= cur[1];
                result += cur[0];
            } else { //물건의 무게가 제한 초과일 경우
                result += cur[0] / cur[1] * limit; // 분할해서 넣음
                limit = 0;
            }
        }
        System.out.println(result);
    }
}
