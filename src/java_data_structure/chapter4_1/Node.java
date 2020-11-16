package java_data_structure.chapter4_1;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T item) {
        data = item;
        next = null;
    }
}
