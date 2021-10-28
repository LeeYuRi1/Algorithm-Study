package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair_17140 implements Comparable<Pair_17140> {
    int num;
    int count;

    public Pair_17140(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Pair_17140 o) {
        if (this.count == o.count) return this.num - o.num;
        return this.count - o.count;
    }
}

public class Main_17140 {
    private static int[][] num = new int[101][101];
    private static int sizeR = 3, sizeC = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int r = Integer.parseInt(input1[0]) - 1;
        int c = Integer.parseInt(input1[1]) - 1;
        int k = Integer.parseInt(input1[2]);
        for (int i = 0; i < 3; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(input2[j]);
            }
        }

        int count = 0;
        while (count <= 100) {
            if (num[r][c] == k) {
                System.out.println(count);
                return;
            }
            if (sizeR >= sizeC) sortR();
            else sortC();
            count++;
        }
        System.out.println(-1);
    }

    // R 연산: 모든 행에 대해서 정렬 수행
    private static void sortR() {
        for (int i = 0; i < sizeR; i++) {
            int[] count = new int[101];
            List<Pair_17140> list = new ArrayList<>();
            for (int j = 0; j < sizeC; j++) {
                count[num[i][j]]++;
                num[i][j] = 0;
            }
            for (int j = 1; j < count.length; j++) {
                if (count[j] != 0) list.add(new Pair_17140(j, count[j]));
            }
            Collections.sort(list);
            int index = 0;
            for (int j = 0; j < list.size(); j++) {
                num[i][index++] = list.get(j).num;
                num[i][index++] = list.get(j).count;
            }
            sizeC = Math.max(sizeC, index);
        }
    }

    // C 연산: 모든 열에 대해서 정렬 수행
    private static void sortC() {
        for (int j = 0; j < sizeC; j++) {
            int[] count = new int[101];
            List<Pair_17140> list = new ArrayList<>();
            for (int i = 0; i < sizeR; i++) {
                count[num[i][j]]++;
                num[i][j] = 0;
            }
            for (int i = 1; i < count.length; i++) {
                if (count[i] != 0) list.add(new Pair_17140(i, count[i]));
            }
            Collections.sort(list);
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                num[index++][j] = list.get(i).num;
                num[index++][j] = list.get(i).count;
            }
            sizeR = Math.max(sizeR, index);
        }
    }
}
