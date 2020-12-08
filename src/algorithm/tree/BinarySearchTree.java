package algorithm.tree;

public class BinarySearchTree {
    public Node root;
    public int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public Node minimum(Node x) { //최소값은 항상 가장 왼쪽 노드에 존재
        while (x.left != null)
            x = x.left;
        return x;
    }

    public Node maximum(Node x) { //최대값은 항상 가장 오른쪽 노드에 존재
        while (x.right != null)
            x = x.right;
        return x;
    }

    public Node successor(Node x) { //successor: key[x]보다 크면서 가장 작은 키를 가진 노드
        if (x.right != null)
            return minimum(x.right);
        Node y = x.p; //y는 node의 부모 노드
        while (y != null && x == y.right) { //부모가 null이 아니면서 node가 부모의 오른쪽 자식인 동안
            x = y;
            y = y.p;
        }
        return y;
    }

    public Node predecessor(Node x) { //predecessor: key[x]보다 작으면서 가장 큰 키를 가진 노드. successor와 반대
        if (x.left != null)
            return maximum(x.left);
        Node y = x.p; //y는 node의 부모 노드
        while (y != null && x == y.left) { //부모가 null이 아니면서 node가 부모의 왼쪽 자식인 동안
            x = y;
            y = y.p;
        }
        return y;
    }

    public Node search(Node x, int k) { //x를 root로 하는 트리에서 k가 어디있는지 찾음
        if (x == null || k == x.data)
            return x;
        if (k < x.data)
            return search(x.left, k);
        else
            return search(x.right, k);
    }

    public void insert(BinarySearchTree t, Node z) {
        Node y = null; //x의 한칸 뒤를 따라옴
        Node x = t.root;

        while (x != null) {
            y = x;
            if (z.data < x.data)
                x = x.left;
            else
                x = x.right;
        }
        z.p = y;
        if (y == null)  //empty tree인 경우
            t.root = z;
        else {
            if (z.data < y.data)
                y.left = z;
            else
                y.right = z;
        }
        size++;
    }

    public Node delete(BinarySearchTree t, Node z) {
        Node y = null;
        Node x = null;

        if (z.left == null || z.right == null) //z는 자식노드가 0개나 1개
            y = z;
        else
            y = successor(z);

        //노드 y를 삭제
        if (y.left != null) // y는 자식이 0개나 1개
            x = y.left;
        else
            x = y.right;

        if (x != null)
            x.p = y.p;

        if (y.p == null) //y가 루트노드라면
            t.root = x;
        else {
            if (y == y.p.left)
                y.p.left = x;
            else
                y.p.right = x;
        }

        //y가 삭제하려는 노드가 아니라 successor
        if (y != z)
            z.data = y.data;

        size--;
        return y;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(binarySearchTree, new Node(30));
        binarySearchTree.insert(binarySearchTree, new Node(20));
        binarySearchTree.insert(binarySearchTree, new Node(25));
        binarySearchTree.insert(binarySearchTree, new Node(40));
        binarySearchTree.insert(binarySearchTree, new Node(10));
        binarySearchTree.insert(binarySearchTree, new Node(35));

        System.out.println(binarySearchTree.minimum(binarySearchTree.root).data);
        System.out.println(binarySearchTree.maximum(binarySearchTree.root).data);
        System.out.println(binarySearchTree.successor(binarySearchTree.root).data);
        System.out.println(binarySearchTree.predecessor(binarySearchTree.root).data);

        System.out.println(binarySearchTree.search(binarySearchTree.root, 35).data);

        System.out.println(binarySearchTree.size);
        binarySearchTree.delete(binarySearchTree, binarySearchTree.root);
        System.out.println(binarySearchTree.size);
    }

}