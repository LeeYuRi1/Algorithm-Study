package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 체육복
public class GymClothes {
    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(5, lost, reserve));
    }

    static public int solution(int n, int[] lost, int[] reserve) {
        List lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List remove = new ArrayList();

        for (int i = 0; i < lostList.size(); i++) {
            if (reserveList.contains(lostList.get(i))) {
                remove.add(lostList.get(i));
            }
        }

        for (int i = 0; i < remove.size(); i++) {
            lostList.remove(remove.get(i));
            reserveList.remove(remove.get(i));
        }

        for (int i = 0; i < reserveList.size(); i++) {
            int r = (int) reserveList.get(i);
            for (int j = 0; j < lostList.size(); j++) {
                int l = (int) lostList.get(j);
                if (l == r-1 || l == r+1) {
                    lostList.remove(j);
                    break;
                }
            }
        }
        return n - lostList.size();
    }
}
