# 그래프

- 자료구조의 일종
- 정점(Node, Vertex), 간선(Edge)으로 이루어져 있음
  정점은 주로 번호가 써있고, 간선은 정점간의 관계를 나타냄
- G = (V, E)로 나타냄

- 경로: 정점 A에서 B로 가는 경로
- 사이클: 정점 A에서 다시 A로 돌아오는 경로(시작 = 도착)

</br>

### 단순 경로와 단순 사이클

- 경로/사이클에서 같은 정점을 두 번 이상 방문하지 않는 경로/사이클
- 특별한 말이 없으면, 일반적으로 사용하는 경로와 사이클은 단순 경로/사이클을 말함

</br>

### 방향 있는 그래프

- Directed Graph
- a -> c는 있지만, c -> a는 없음
- 간선에 방향이 있음

</br>

### 방향 없는 그래프

- Undirected Graph
- 간선에 방향이 없음 
- a - c는 a -> c와 c -> a를 나타냄
- 양방향 그래프(Bidirection Graph)라고도 함
  양방향 그래프는 방향 그래프로 바꿔서 저장함. a -> c, c -> a 간선 모두 저장해서 문제를 품

</br>

### 간선 여러개

- 두 정점 사이에 간선이 여러 개일 수도 있음
- 두 간선은 서로 다른 간선임
- 최단거리 문제에서는 간선이 여러개이면 작은거만 취함

</br>

### 루프

- 간선의 양 끝 점이 같은 경우
- a -> a

</br>

### 가중치

- 간선에 가중치가 있는 경우
  : a에서 b로 이동하는 거리, 이동하는데 필요한 시간, 이동하는데 필요한 비용 등등
- 가중치가 없는 경우에는 모든 가중치를 1이라고 생각하면 됨

</br>

### 차수

- 정점과 연결되어 있는 간선의 개수
- 방향 그래프일 경우 차수는 두가지로 나누어짐
  : 정점으로 들어오는 간선의 개수(in-degree), 나가는 간선의 개수(out-degree)



</br></br>

## 그래프의 표현

- 주로 나오는 입력 형식
  첫째 줄에는 정점의 개수와 간선의 개수
  둘째 줄부터 간선의 정보

- 그래프를 저장하는 방법: 인접 행렬, 인접 리스트

</br>

### 인접 행렬

- 정점의 개수를 V이라고 했을 때, V x V 크기의 이차원 배열을 이용
- A[i] [j] = 1(i -> j 간선이 있을 때), 0(없을 때)
- 양방향 그래프의 경우 A[i] [i]를 기준으로 대칭
- 자주 사용하지 않음: 없는 간선도 저장하기 때문. 주로 쉬운 문제를 풀 때 사용

![1611307487207](https://user-images.githubusercontent.com/33548856/105579751-c16fb580-5dcb-11eb-869e-5906a361c044.png)

```java
int n = sc.nextInt(); //정점 개수
int m = sc.nextInt(); //간선 개수
int[][] a = new int[n+1][n+1];
for (int i = 0; i < m; i++) {
	int u = sc.nextInt();
	int v = sc.nextInt();
	int w = sc.nextInt(); // 가중치

	a[u][v] = 1; //방향그래프
	a[u][v] = a[v][u] = 1; //가중치 없는 양방향 그래프
	a[u][v] = a[v][u] = w; //가중치 있는 양방향 그래프
```

</br>

### 인접 리스트

- Linked List를 이용해서 구현
- A[i] = i와 연결된 정점을 Linked List로 포함하고 있음
  i와 연결된 정점이 몇개가 나올지 알 수 없기 때문에 Linked List사용
- 가중치가 있으면 A[i] = i와 연결된 정점과 그 간선의 가중치를 Linked List로 포함하고 있음
- 간선이 여러개일 경우 인접 리스트를 사용하는게 더 좋음
- 저장되는것이 정점이 아닌 간선임
  모든 간선이 1번씩 저장 -> 총 필요한 공간의 개수는 간선의 개수 O(E)
- Linked List는 구현하는데 시간이 오래걸리기 때문에, 주로 vector나 arrayList와 같이 길이를 변경할 수 있는 배열을 이용해서 구현함

</br>

- 가중치 없는 그래프

![1611311231281](https://user-images.githubusercontent.com/33548856/105579752-c59bd300-5dcb-11eb-9694-d089b9e58645.png)

```java
int n = sc.nextInt();
int m = sc.nextInt();
ArrayList<Integer>[] a = new ArrayList[n + 1];

for (int i = 1; i <= n; i++)
	a[i] = new ArrayList<>();

for (int i = 0; i < m; i++) {
	int u = sc.nextInt();
	int v = sc.nextInt();
	a[u].add(v);
	a[v].add(u);
}
```

</br>

- 가중치 있는 그래프

![1611311826511](https://user-images.githubusercontent.com/33548856/105579754-c896c380-5dcb-11eb-915d-e03e12f65ea5.png)

</br>

### 공간 복잡도

- 인접 행렬: O(V^2)
- **인접 리스트: O(E)**

</br>

### 간선 리스트

- 인접 행렬, 인접 리스트를 사용할 수 없는 경우 사용
- 배열을 이용해서 구현
- 간선을 모두 저장하고 있음



</br></br>

## 그래프의 탐색

- 목적: 모든 정점을 1번씩 방문
- DFS: 깊이 우선 탐색 - 최대한 깊숙히 많이 가는 것, 스택 사용
- BFS: 너비 우선 탐색 - 최대한 넓게 가는 것, 큐 사용, 모든 가중치가 1일때 최단거리 찾기 

</br>

### 깊이 우선 탐색 (DFS)

- 스택을 이용해서 갈 수 있는 만큼 최대한 많이 가고, 갈 수 없으면 이전 정점으로 돌아감

- 한번씩 방문하기 위해서 체크하는 배열 필요
  check[i]: 0(아직 방문하지 않은 경우) 또는 1(방문한 경우)

</br>

- 인접 행렬을 이용한 구현
- 시간복잡도: O(V^2) V는 정점의 개수

```java
void dfs(int x) {
	//x를 방문했다고 체크
	check[x] = true;
    
	//다음 정점을 찾는 과정
	for (int i = 1; i <= n; i++) {
        // 간선이 있고, i를 방문하지 않았는지 확인
		if (a[x][i] == 1 && check[i] == false) { 
			dfs(i);
		}
	}
}
```

</br>

- 인접 리스트를 이용한 구현
- 시간복잡도: O(V+E)

```java
void dfs(int x) {
	check[x] = true;
    
	//a[x]: x와 연결된 정점이 모두 저장
	for (int i = 0; i < a[x].size; i++) {
		int y = a[x][i];
		if (check[y] == false) //다음 정점을 방문하지 않았으면 방문함
			dfs(y);
	}
}
```

</br>

### 너비 우선 탐색 (BFS)

- 큐를 이용해서 지금 위치에서 갈 수 있는 것을 모두 큐에 넣는 방식
- 큐에 넣을 때 방문했다고 체크해야 함

</br>

- 인접 행렬을 이용한 구현
- 시간복잡도: O(V^2) 

```java
void bfs(int start) {
	Queue<Integer> q = new LinkedList<>();
	q.add(start);
	check[start] = true;

	while (!q.isEmpty()) {
		int x = q.remove();
		//x와 연결되어있는 다음 정점을 찾음
		for (int i = 1; i <= n; i++) {
			if (a[x][i] == 1 && check[i] == false) {
				check[i] = true;
				q.add(i);
			}
		}
	}
}
```

</br>

- 인접 리스트를 이용한 구현
- 시간복잡도: O(V+E)

```java
void bfs(int start) {
	Queue<Integer> q = new LinkedList<>();
	q.add(start);
	check[start] = true;

	while (!q.isEmpty()) {
		int x = q.remove();
		for (int y : a[x]) {
			if (check[y] == false) {
				check[y] = true;
				q.add(y);
			}
		}
	}
}
```



</br></br>

## 연결 요소

- 그래프가 나누어져 있는 경우가 있을 수도 있음
- 나누어진 각각의 그래프를 연결 요소라고 함
- 연결 요소에 속한 모든 정점을 연결하는 경로가 있어야 함
- 또, 다른 연결 요소에 속한 정점과 연결하는 경로가 있으면 안됨
- 아래 그림은 그래프 1개, 연결 요소 2개
- 연결 요소를 구하는 것은 DFS나 BFS 탐색을 이용해서 구할 수 있음

![1611671186259](C:\Users\LEE\AppData\Roaming\Typora\typora-user-images\1611671186259.png)

```java
// components의 개수를 dfs가 시작할 때마다 세어줌
int components = 0;
for (int i = 1; i <= n; i++) {
	if (!check[i]) {
		dfs(i);
		components++;
	}
}
```



</br></br>

## 이분 그래프

- 그래프를 다음과 같이 A와 B로 나눌 수 있으면 이분 그래프라고 함
- A에 포함되어 있는 정점끼리 연결된 간선이 없음
- B에 포함되어 있는 정점끼리 연결된 간선이 없음
- 모든 간선의 한 끝 점은 A에, 다른 끝 점은 B에 연결
- 그래프를 DFS또는 BFS 탐색으로 이분 그래프인지 아닌지 알아낼 수 있음

![1611672913585](C:\Users\LEE\AppData\Roaming\Typora\typora-user-images\1611672913585.png)

- check[i] == 0 (아직 방문하지 않음)
  check[i] == 1(방문 했는데 정점의 색이 빨강)
  check[i] == 2(방문 했는데 정점의 색이 파랑)

</br></br>

[출저: code.plus]