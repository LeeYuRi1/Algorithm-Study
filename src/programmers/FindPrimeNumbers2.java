package programmers;

import java.util.ArrayList;
import java.util.List;

// 소수 찾기 (level 2)
public class FindPrimeNumbers2 {

    public static List<Integer> list;

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        list = new ArrayList<>();
        for (int i = 1; i <= numbers.length(); i++) {
            permutation(arr, 0, arr.length, i);
        }
        return primeNum(list);
    }

    private static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            add(arr, r);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    private static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    private static void add(int[] arr, int r) {
        String result = "";
        for (int i = 0; i < r; i++)
            result += arr[i];
        if (!list.contains(Integer.parseInt(result)))
            list.add(Integer.parseInt(result));
    }

    private static int primeNum(List<Integer> numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.size(); i++) {
            boolean check = true;
            if (numbers.get(i) <= 1) check = false;
            for (int j = 2; j * j <= numbers.get(i); j++) {
                if (numbers.get(i) % j == 0) {
                    check = false;
                }
            }
            if (check) answer++;
        }
        return answer;
    }
}
