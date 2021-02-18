package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    public String data;
    public Node left;
    public Node right;

    public Node(String item) {
        data = item;
        left = null;
        right = null;
    }
}

class Tree {
    public Node root;

    public void add(String data, String left, String right) {
        if (root == null) {
            root = new Node(data);
            if (!left.equals(".")) root.left = new Node(left);
            if (!right.equals(".")) root.right = new Node(right);
        } else {
            search(root, data, left, right);
        }
    }

    public void search(Node root, String data, String left, String right) {
        if (root == null) return;
        if (root.data.equals(data)) {
            if (!left.equals(".")) root.left = new Node(left);
            if (!right.equals(".")) root.right = new Node(right);
        } else {
            search(root.left, data, left, right);
            search(root.right, data, left, right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data);
            inorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }
}

public class Main_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        while (n-- > 0) {
            String[] data = br.readLine().split(" ");
            tree.add(data[0], data[1], data[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}
