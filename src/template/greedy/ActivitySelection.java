package template.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 활동 선택 문제
public class ActivitySelection {
    public static void main(String[] args) {
        int[][] activity = {{1, 3}, {2, 5}, {4, 7}, {1, 8}, {5, 9}, {8, 10}, {9, 11}, {11, 14}, {13, 16}};
        //끝나는 시간이 빠른 순서대로 정렬
        Arrays.sort(activity, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        int last = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < activity.length; i++) {
            if (last < activity[i][0]) { // 시작 시간과 끝나는 시간이 같아도 가능하면(겹쳐도 되면) <=
                last = activity[i][1];
                result.add(i + 1);
            }
        }
        for (int i : result) System.out.print(i + " ");
    }
}
