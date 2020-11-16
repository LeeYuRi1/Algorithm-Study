package java_data_structure.chapter4_1;

public class MySingleLinkedList<T> {

    public Node<T> head;
    public int size;

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    // 연결리스트 처음에 삽입
    public void addFirst(T item) {
        // 1. 새로운 노드를 만들고 추가할 데이터를 저장
        Node<T> newNode = new Node<T>(item);
        // 2. 새로운 노드의 next 필드가 현재의 head 노드를 가리키도록 함
        newNode.next = head;
        // 3. 새로운 노드를 새로운 head 노드로 함
        head = newNode;
        size++;
    }

    // 어떤 노드의 다음에 삽입
    public void addAfter(Node<T> before, T item) {
        // 1. 새로운 노드를 만들고 추가할 데이터를 저장
        Node<T> newNode = new Node<T>(item);
        // 2. 새로운 노드의 next 필드가 before의 다음 노드를 가리키도록 함
        newNode.next = before.next;
        // 3. 새로운 노드를 before의 다음 노드로 만듦
        before.next = newNode;
        size++;
    }

    // index번째 위치에 새로운 데이터를 삽입
    public void add(int index, T item) { //insert
        if (index < 0 || index > size)
            return;

        if (index == 0)
            addFirst(item);
        else {
            Node<T> q = getNode(index - 1);
            addAfter(q, item);
        }
    }

    // 연결리스트의 처음 노드를 삭제
    public T removeFirst() {
        // head가 null이 아니라면 head가 현재 head노드의 다음 노드를 가리키게 만듦
        if (head == null)
            return null;

        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    // 어떤 노드의 다음 노드를 삭제
    public T removeAfter(Node<T> before) {
        // before의 다음 노드가 null이 아니라면 before의 next 필드가 현재 next노드의 다음 노드를 가리키게 만듦
        if (head == null)
            return null;

        T temp = before.next.data;
        before.next = before.next.next;
        size--;
        return temp;
    }

    // index번째 노드를 삭제하고, 그 노드에 저장된 데이터를 반환
    public T remove(int index) { //delete
        if (index < 0 || index >= size)
            return null;
        if (index == 0)
            return removeFirst();
        Node<T> prev = getNode(index - 1);
        return removeAfter(prev);
    }

    // 입력된 스트링을 저장한 노드를 찾아 삭제. 삭제된 노드에 저장된 스트링을 반환
    public T remove_n(T item) {
        // 삭제할 노드를 찾음. 하지만 노드를 삭제하기 위해서는 삭제할 노드가 아니라 직전 노드의 주소 필요
        // 참조변수를 2개 씀 - p는 찾고있는 데이터를 비교, q는 항상 p의 직전 노드를 가리킴. p가 첫번째 노드일 경우 q는 null
        Node<T> p = head, q = null;
        while (p != null && !p.data.equals(item)) {
            q = p;
            p = p.next;
        }
        if (p == null)
            return null;
        if (q == null)
            return removeFirst();
        return removeAfter(q);
    }

    // 입력된 데이터 item과 동일한 데이터를 저장한 노드를 찾아서 그 노드번호를 반환. 그것을 위해 연결리스트를 순회
    public int indexOf(T item) { // search
        Node<T> p = head;
        int index = 0;
        while (p != null) {
            if (p.data.equals(item))
                return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    // 연결리스트의 index번째 노드의 주소를 반환함
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        Node<T> p = head;
        for (int i = 0; i < index; i++)
            p = p.next;
        return p;
    }

    // index번째 노드에 저장된 데이터를 반환
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
//        Node<T> p = head;
//        for (int i = 0; i < index; i++)
//            p = p.next;
//        return p.data;
        return getNode(index).data;
    }

    public static void main(String[] args) {
        MySingleLinkedList<String> list = new MySingleLinkedList<>();
        list.add(0, "sat");
        list.add(1, "fri");
        list.add(0, "mon");
        list.add(2, "tue"); // m,s,t,f

        String str = list.get(2); // tue
        String str2 = list.remove(2); // m,s,f

        int pos = list.indexOf("fri"); // 2

        System.out.println(str);
        System.out.println(str2);
        System.out.println(pos);
    }

}
