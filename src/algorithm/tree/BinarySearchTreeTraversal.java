package algorithm.tree;

public class BinarySearchTreeTraversal {
    public Node root;
    public int size;

    public BinarySearchTreeTraversal() {
        root = null;
        size = 0;
    }

    //중순위(inorder) 순회
    public void inorderTreeWalk(Node node) { //node를 루트로 하는 트리를 inorder 순회, 시간복잡도 O(n)
        if (node != null) {
            inorderTreeWalk(node.left);
            System.out.print(node.data);
            inorderTreeWalk(node.right);
        }
    }

    //선순위(preorder) 순회
    public void preorderTreeWalk(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preorderTreeWalk(node.left);
            preorderTreeWalk(node.right);
        }
    }

    //후순위(postorder) 순회
    public void postorderTreeWalk(Node node) {
        if (node != null) {
            postorderTreeWalk(node.left);
            postorderTreeWalk(node.right);
            System.out.print(node.data);
        }
    }

}
