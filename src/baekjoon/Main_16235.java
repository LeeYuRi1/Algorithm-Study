package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tree_16235 {
    int x;
    int y;
    int age;

    public Tree_16235(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}

public class Main_16235 {
    private static int[][] area;
    private static int[][] plus;
    private static List<Tree_16235> trees = new LinkedList<>();
    private static Queue<Tree_16235> kill = new LinkedList<>();
    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(input1[2]);
        area = new int[n][n];
        plus = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = 5;
                plus[i][j] = Integer.parseInt(input2[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            String[] input3 = br.readLine().split(" ");
            trees.add(new Tree_16235(Integer.parseInt(input3[0]) - 1, Integer.parseInt(input3[1]) - 1, Integer.parseInt(input3[2])));
        }
        for (int i = 0; i < k; i++) {
            fourSeasons(n);
            if (trees.size() == 0) break;
        }
        System.out.println(trees.size());
    }

    private static void fourSeasons(int n) {
        // 봄: 나무가 자신의 나이만큼 양분을 먹고 나이 1증가, 하나의 칸에 여러 나무가 있으면 나이가 어린 나무부터 양분 먹음
        // 만약 양분 부족해서 자기 나이만큼 양분 먹을수없으면 죽음
        for (Iterator<Tree_16235> it = trees.iterator(); it.hasNext(); ) {
            Tree_16235 tree = it.next();
            if (tree.age > area[tree.x][tree.y]) {
                kill.offer(tree);
                it.remove();
            } else {
                area[tree.x][tree.y] -= tree.age;
                tree.age += 1;
            }
        }

        // 여름: 죽은 나무가 양분으로 변함. 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
        while (!kill.isEmpty()) {
            Tree_16235 tree = kill.poll();
            area[tree.x][tree.y] += tree.age / 2;
        }

        // 가을: 나무 번식. 번식하는 나무는 나이가 5의 배수여야함. 인접한 8개의 칸에 나이 1인 나무가 생김
        List<Tree_16235> newTree = new LinkedList<>();
        for (Tree_16235 tree : trees) {
            if (tree.age % 5 != 0) continue;
            for (int j = 0; j < 8; j++) {
                int nx = tree.x + dx[j];
                int ny = tree.y + dy[j];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                newTree.add(new Tree_16235(nx, ny, 1));
            }
        }
        trees.addAll(0, newTree);

        // 겨울: 양분을 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area[i][j] += plus[i][j];
            }
        }
    }
}
