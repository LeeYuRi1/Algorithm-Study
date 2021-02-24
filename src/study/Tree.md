# 트리

- 자료구조의 일종

- 사이클이 없는 그래프
- 정점의 개수: V
- 간선의 개수: V-1

</br></br>



## 루트 있는 트리

- 루트가 있는 트리

- 루트부터 아래로 방향을 정할 수 있음
- 부모(parent): 두 노드가 연결되어 있을 때 루트에 가까운 것이 부모임, 부모가 없으면 루트
- 자식(children): 자식이 없으면 그 정점은 단말 정점(terminal node, leaf node)
- 형제(sibling): 같은 부모를 가지면 형제
- 깊이(depth, level): 루트에서부터 거리(루트의 깊이를 0으로 하는 경우와 1로 하는 경우가 있음)
- 높이(height): 깊이 중 가장 큰 값
- 조상, 자손(ancestor, descendent): 루트를 넘지 않고 p -> q로 갈 수 있을 때, p가 q보다 루트에 가까우면 p는 q의 조상, q는 p의 자손
- 이진 트리: 자식을 최대 2개만 가지고 있는 트리

</br></br>



## 트리의 표현

- 트리는 그래프이기 때문에, 그래프의 표현과 같은 방식으로 저장할 수 있음
- 또는 트리의 모든 노드는 부모를 하나 또는 0개만 가지기 때문에 **부모만 저장하는 방식**으로 저장할 수 있음
- 부모가 0개인 경우는 트리의 루트인데, 이 경우 부모를 -1이나 0으로 처리하는 방식을 사용함

- 이진 트리의 경우에는 배열로 표현할 수 있음
  - 부모의 노드가 x인 경우에 자식의 노드는 2 * x, 2 * x + 1로 나타내면 됨
    (자식이 한쪽만 있을 경우 매우 비효율적. 위에부터 꽉 채워지는 트리를 만들 때만 사용)
  - A[i] [0]에 i의 왼쪽 자식,  A[i] [1]에 i의 오른쪽 자식을 저장할 수 있음(인접리스트의 변형)

</br></br>



## 트리의 순회

이진 트리에서 트리를 순회하는 방법

- 트리의 모든 노드를 방문하는 순서임
- 그래프의 경우에는 DFS와 BFS가 있었음
- 트리에서도 위의 두 방법을 사용할 수 있지만, 트리에서만 사용할 수 있는 세 방법이 있음
  - 프리오더 (전위 순회)
  - 인오더 (중위 순회)
  - 포스트오더 (후위 순회)
- 세 방법의 차이는 노드 방문을 언제 하는지의 차이

</br>

### 프리오더

그래프의 DFS의 순서와 같음

1. 노드 방문
2. 왼쪽 자식 노드를 루트로 하는 서브트리 프리오더
3. 오른쪽 자식 노드를 루트로 하는 서브트리 프리오더

```java
public void preorder(Node node) {
	if (node != null) {
		System.out.print(node.data);
		preorder(node.left);
		preorder(node.right);
	}
}
```

</br>

### 인오더

BST(binary search tree)에서 delete를 구현할 때 주로 사용

1. 왼쪽 자식 노드를 루트로 하는 서브트리 인오더
2. 노드 방문
3. 오른쪽 자식 노드를 루트로 하는 서브 트리 인오더

```java
public void inorder(Node node) {
	if (node != null) {
		inorder(node.left);
		System.out.print(node.data);
		inorder(node.right);
	}
}
```

</br>

### 포스트오더

1. 왼쪽 자식 노드를 루트로 하는 서브트리 포스트오더
2. 오른쪽 자식 노드를 루트로 하는 서브트리 포스트오더
3. 노드 방문

```java
public void postorder(Node node) {
	if (node != null) {
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data);
	}
}
```

</br></br>



## 트리의 탐색

- 트리의 탐색은 DFS/BFS 알고리즘을 이용해서 할 수 있음
- 트리는 사이클이 없는 그래프이기 때문에 임의의 두 정점 사이의 경로는 1개임
- 따라서 BFS 알고리즘을 이용해서 최단거리를 구할 수 있음
- 이유: 경로가 1개라 찾은 그 경로가 최단 경로

</br>

- 보통 문제에서는 트리라고 써있지 않음

- ex) 도시 N개, 도로 N-1개 + 연결되어있는 그래프이면 트리
  임의의 두 도시 사이에 경로가 항상 존재
  두 도시 사이에 경로가 1개, 방향이 없어야 함

</br>

- 트리의 부모 찾기

```java
private static void bfs() {
	Queue<Integer> queue = new LinkedList<>();
	queue.add(1);
	check[1] = true;
	while (!queue.isEmpty()) {
		int x = queue.remove();
		for (int y : a[x]) {
			if (!check[y]) {
				check[y] = true;
				parent[y] = x;
				queue.add(y);
            }
        }
    }
}
```



</br></br>

[출저: code.plus]