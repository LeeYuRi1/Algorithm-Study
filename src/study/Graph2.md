# 그래프2

</br>

## DAG

- Directed Acyclic Graph 
- 사이클이 없는 방향 있는 그래프
- 사이클이 없기 때문에 일반적인 그래프에서 할 수 없는 다른 알고리즘 사용
  - 대표적으로 위상 정렬

![1619522611322](C:\Users\LEE\AppData\Roaming\Typora\typora-user-images\1619522611322.png)

- 1번, 2번을 모두 완료해야 4번을 할 수 있음
- 가능한 순서: 1,2,3,4,5,7,6,8,9 또는 1,2,3,9,4,5,7,6,8 
- 이렇게 어떤 그래프의 순서를 나타내는 것을 위상 정렬이라고 함

</br></br>

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

</br></br>