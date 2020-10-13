package algorithm.recursion;

public class ExplicitParameter {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(search(array, array.length-1, 3));
        System.out.println(search_explicit(array, 0, array.length-1, 3));
        System.out.println(findMax(array, 0, array.length-1));

        String[] strArray = {"a", "b", "c", "d"};
        System.out.println(binarySearch(strArray, "c", 0, strArray.length-1));
    }

    // 순차탐색
    private static int search(int[] data, int n, int target) {
        for (int i = 0; i < n; i++)
            if (data[i] == target)
                return i;
        return -1;
    }

    // 순차탐색 - 시작점위치를 명시적으로 지정
    private static int search_explicit(int[] data, int begin, int end, int target) {
        if (begin > end)
            return -1;
        else if (target == data[begin])
            return begin;
        else
            return search_explicit(data, begin + 1, end, target);
    }

    // 최대값 찾기
    private static int findMax(int[] data, int begin, int end) {
        if (begin == end)
            return data[begin];
        else
            return Math.max(data[begin], findMax(data, begin + 1, end));
    }

    // 2진 검색
    private static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end)
            return -1;
        else {
            int middle = (begin + end) / 2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0)
                return middle;
            else if (compResult < 0)
                return binarySearch(items, target, begin, middle - 1);
            else
                return binarySearch(items, target, middle + 1, end);
        }
    }

}
