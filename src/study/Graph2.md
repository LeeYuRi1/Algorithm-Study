# 그래프2

</br>

## DAG

- Directed Acyclic Graph 
- 사이클이 없는 방향 있는 그래프
- 사이클이 없기 때문에 일반적인 그래프에서 할 수 없는 다른 알고리즘 사용
  - 대표적으로 위상 정렬

![1619522611322](https://user-images.githubusercontent.com/33548856/116537054-b1162c00-a920-11eb-8096-a05e268d0422.png)

- 1번, 2번을 모두 완료해야 4번을 할 수 있음
- 가능한 순서: 1,2,3,4,5,7,6,8,9 또는 1,2,3,9,4,5,7,6,8 
- 이렇게 어떤 그래프의 순서를 나타내는 것을 위상 정렬이라고 함

</br>

</br>

## 위상 정렬

- 어떤 일을 하는 순서를 찾는 알고리즘
- 1 -> 2일 때 2를 하기 전에 1을 먼저 해야함
- 들어오는 간선(indegree)가 0이 되어야 일을 할 수 있음
- 큐에 들어가는 것은 indegree가 0이어야 함

```java
while (m-- > 0) {
	String[] s = br.readLine().split(" ");
	int a = Integer.parseInt(s[0]);
	int b = Integer.parseInt(s[1]);
	g[a].add(b);
	indegree[b]++;
}
```

- indegree의 개수를 세어 줌

```java
Queue<Integer> q = new LinkedList<>();
for (int i = 1; i <= n; i++) {
	if (indegree[i] == 0) q.add(i);
}
while (!q.isEmpty()) {
	int x = q.remove();
	System.out.print(x + " ");
	for (int y : g[x]) {
		indegree[y]--;
		if (indegree[y] == 0) q.add(y);
	}
}
```

</br>

- 위상정렬 응용
  - 선행관계가 주어졌을 때 모두 마치는 가장 빠른 시간

```java
private static int topologicalSort(ArrayList<Integer>[] g, int[] indegree, int[] time, int n) {
	PriorityQueue<Integer> q = new PriorityQueue<>();
	int[] ans = new int[n + 1];
	for (int i = 1; i < n; i++) {
		if (indegree[i] == 0) {
			q.offer(i);
		}
		ans[i] = time[i];
	}
	while (!q.isEmpty()) {
		int x = q.poll();
		for (int y : g[x]) {
			indegree[y]--;
            // 동시에 할 수 있으므로 max값을 넣음
			ans[y] = Math.max(ans[y], ans[x] + time[y]); 
			if (indegree[y] == 0) {
				q.offer(y);
			}
		}
	}
	int max = 0;
	for (int i = 1; i <= n; i++) {
		max = Math.max(max, ans[i]);
	}
	return max;
}
```

</br>

</br>

## MST

- Minimum Spanning Tree 최소 스패닝 트리
- 스패닝 트리: 그래프에서 일부 간선을 선택해서 만든 트리
- 최소 스패닝 트리: 스패닝 트리 중에 선택한 간선의 가중치의 합이 최소인 트리
- MST를 구하는 알고리즘
  - 프림: 정점을 점점 확장해나가는 방식
  - 크루스칼: 간선을 점점 확장해나가는 방식

</br>

#### 프림

1. 그래프에서 아무 정점이나 선택함
2. 선택한 정점과 선택하지 않은 정점을 연결하는 간선중에 최소값을 고름
   이 간선을 (u, v)라고 함(u = 선택, v = 선택하지 않음)
3. 선택한 간선을 MST에 추가하고, v를 선택함
4. 모든 정점을 선택하지 않았다면 2번 단계로 돌아감

- 우선 순위 큐를 사용해서 구현
  - 시간복잡도: O(ElogE)

```java
for (int i = 0; i < m; i++) {
	g[start].add(new Edge_1922(end, weight)); // 가중치 있는 무방향 그래프
	g[end].add(new Edge_1922(start, weight));
}

PriorityQueue<Edge_1922> q = new PriorityQueue<>();
for (Edge_1922 e : g[1]) {
	q.offer(e); // 정점 1에 연결된 간선들을 우선순위큐에 넣음
}
check[1] = true;
int ans = 0;
while (!q.isEmpty()) {
	Edge_1922 e = q.poll();
	if (!check[e.end]) { // 선택되지 않은 정점일 때 (선택-선택x 이어야 하기 때문)
		check[e.end] = true; // 정점 체크
		ans += e.weight;
		for (Edge_1922 y : g[e.end]) { // 선택한 정점에 연결된 간선들을 넣음
			q.offer(y);
		}
	}
}
System.out.println(ans);
```

</br>

#### 크루스칼

- Union-Find 알고리즘 이용
- 가중치가 작은 Edge부터 순서대로 살펴봄
- Edge e가 (u, v, c)일 때, u와 v가 다른 집합이면 e를 MST에 추가함

