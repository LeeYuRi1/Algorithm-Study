package programmers;

// 타겟 넘버
public class TargetNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }

    private static int dfs(int i, int sum, int[] numbers, int target) {
        if (i == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }
        int sum1 = sum + numbers[i];
        int sum2 = sum - numbers[i];
        return dfs(i + 1, sum1, numbers, target) + dfs(i + 1, sum2, numbers, target);
    }
}
