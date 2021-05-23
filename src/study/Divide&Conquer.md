# 분할 정복

- 문제를 2개 또는 그 이상의 작은 부분 문제로 나눈 다음 푸는 것 (분할)
- 푼 다음에는 다시 합쳐서 정답을 구할 때도 있음 (정복)
- 대표적인 분할 정복 알고리즘
  - 퀵 소트
  - 머지 소트
  - 큰 수 곱셈 (카라추바 알고리즘)
  - FFT

- 분할 정복과 다이나믹은 문제를 작은 부분 문제로 나눈 다는 점은 동일함
  - 분할 정복: 문제가 겹치지 않음
  - 다이나믹: 문제가 겹쳐서 겹치는 것을 Memoization으로 해결
- 분할 정복 문제는 어떻게 함수를 만들어야 할지 결정해야 함
  - 함수 -> 문제를 푸는 함수
  - 그 함수 내에서는 작은 문제를 어떻게 호출해야 할지 결정
  - 만약에 부분 문제의 정답을 합쳐야 하는 경우에는 합치는 것을 어떻게 해야 할지 결정

</br>

</br>

## 이분 탐색 (Binary Search)

- 정렬되어 있는 리스트에서 어떤 값을 빠르게 찾는 알고리즘
- 리스트의 크기를 N이라고 했을 때 logN의 시간이 걸림

```java
while (left <= right) {
	int mid = (left + right) / 2; 
    //오버플로우 날 수 있기 때문에 left + (right - left) / 2;로 쓸 수 있음
	if (a[min] == x) {
		position = mid;
		break;
	} else if (a[mid] > x) {
		right = mid - 1;
	} else {
		left = mid + 1;
	}
}
```

</br>

</br>

## 머지 소트 (Merge Sort)

- N개를 정렬하는 알고리즘
- N개를 N/2, N/2개로 나눔
- 왼쪽 N/2와 오른쪽 N/2를 정렬함
- 두 정렬한 결과를 하나로 합침
- O(NlogN)이 걸림

![1617453756785](https://user-images.githubusercontent.com/33548856/113512768-120c4780-95a1-11eb-801c-9dbef4ccf8b9.png)

```java
void sort(int start, int end) {
	if (start == end) return; //크기가 1인 경우(정렬할 것이 없음) 종료
	int mid = (start + end) / 2;
	sort(start, mid); // 왼쪽 절반
	sort(mid + 1, end); // 오른쪽 절반
	merge(start, end); // 두 배열을 합침
}

void merge(int start, int end) {
	int mid = (start + end) / 2;
	int i = start;
	int j = mid + 1;
	int k = 0;
	while (i <= mid && j <= end) {
		if (a[i] <= a[j]) b[k++] = a[i++];
		else b[k++] = a[j++];
	}
	while (i <= mid) b[k++] = a[i++];
	while (j <= end) b[k++] = a[j++];
	for (int x = start; x <= end; x++) {
		a[x] = b[x - start];
	}
}
```

</br>

</br>

