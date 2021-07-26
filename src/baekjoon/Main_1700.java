package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Main_1700 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(s2[i]);

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < k; i++) {
            // 이미 있으면 넘어감
            if (set.contains(arr[i])) continue;
            // 만약 멀티탭이 다 찼으면
            if (set.size() == n) {
                // 둘중 뒤에 없는 것을 뺌
                // 만약 둘 다 나온다면 뒤에 나오는 것을 빼기
                HashSet<Integer> useSet = new HashSet<>();
                int last = 0; // 가장 마지막에 나오는 것이 아닌 처음 등장하는게 가장 늦은 것!
                for (int j = i + 1; j < k; j++) {
                    if (set.contains(arr[j])) {
                        if (!useSet.contains(arr[j])) last = arr[j];
                        useSet.add(arr[j]);
                    }
                }
                // 만약 뒤에 꽃혀있는게 둘다 나온다면 뒤에있는거를 빼기
                int del = 0;
                if (useSet.size() == n) del = last;
                else {
                    // 안나오는게 있으면 그거를 빼주기
                    Iterator<Integer> iter = set.iterator();
                    while (iter.hasNext()) {
                        int next = iter.next();
                        if (!useSet.contains(next)) {
                            del = next;
                            break;
                        }
                    }
                }
                // 빼고 새로 꽂아주기
                set.remove(del);
                set.add(arr[i]);
                count++;
            } else {
                // 멀티탭에 자리가 남았으면 꽂아줌
                set.add(arr[i]);
            }
        }
        System.out.println(count);
    }
}
