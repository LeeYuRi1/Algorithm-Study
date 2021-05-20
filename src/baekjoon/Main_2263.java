package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2263 {
    private static int[] inorder;
    private static int[] postorder;
    private static int[] position;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        String[] post = br.readLine().split(" ");
        inorder = new int[n];
        postorder = new int[n];
        position = new int[n + 1];
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(in[i]);
            postorder[i] = Integer.parseInt(post[i]);
            position[Integer.parseInt(in[i])] = i;
        }
        findPreOrder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    private static void findPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;
        int root = postorder[postEnd];
        sb.append(root + " ");
        int indexInorderRoot = position[root];
        int range = indexInorderRoot - inStart;
        findPreOrder(inStart, indexInorderRoot - 1, postStart, postStart + range - 1);
        findPreOrder(indexInorderRoot + 1, inEnd, postStart + range, postEnd - 1);
    }
}
