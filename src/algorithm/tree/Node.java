package algorithm.tree;

public class Node<T> {
    public T data;
    public Node left; //왼쪽 자식
    public Node right; //오른쪽 자식
    public Node p; //부모노드: 반드시 필요한 경우가 아니면 보통 생략

    public Node(T item) {
        data = item;
        left = null;
        right = null;
        p = null;
    }
}