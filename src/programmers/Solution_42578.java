package programmers;

import java.util.HashMap;

// 위장
public class Solution_42578 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            // 의상종류, 개수 저장
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        return answer - 1; // 아무것도 입지 않는 경우 제외
    }
}
