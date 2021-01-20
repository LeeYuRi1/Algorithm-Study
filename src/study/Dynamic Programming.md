# 다이나믹 프로그래밍

- 큰 문제를 작은 문제로 나눠서 푸는 알고리즘
- Dynamic Programming의 다이나믹은 아무 의미가 없음

- 두 가지 속성을 만족해야 다이나믹 프로그래밍 문제를 풀 수 있음
  - Overlapping Subproblem
    - 큰 문제와 작은 문제를 같은 방법으로 풀 수 있음
    - 문제를 작은 문제로 쪼갤 수 있음
  - Optimal Substructure
    - 문제의 정답을 작은 문제의 정답에서 구할 수 있음



- 다이나믹 프로그래밍에서 각 문제는 한 번만 풀어야 함
- Optimal Substructure를 만족하기 때문에, 같은 문제는 구할 때마다 정답이 같음
- 따라서, 정답을 한 번 구했으면, 정답을 어딘가에 메모해놓음
- 이런 메모하는 것을 코드의 구현에서는 배열에 저장하는 것으로 할 수 있음
- 메모를 한다고 해서 영어로 Memoization 이라고 함



## 다이나믹을 푸는 두 가지 방법

- Top-down
  1. 문제를 작은 문제로 나눔
  2. 작은 문제를 품
  3. 작은 문제를 풀었으니, 이제 문제를 품
- Bottom-up
  1. 문제를 크기가 작은 문제부터 차례대로 품
  2. 문제의 크기를 조금씩 크게 만들면서 문제를 점점 품
  3. 작은 문제를 풀면서 왔기 때문에, 큰 문제는 항상 풀 수 있음
  4. 그러다보면, 언젠간 풀어야 하는 문제를 풀 수 있음

- 피보나치 수 (F0=0, F1=1, Fn = Fn-1 + Fn-2)

  ```java
  int fibonacci(int n) {
  	if (n <= 1) {
  		return n;
  	} else {
  		return fibonacci(n-1) + fibonacci(n-2);
  	}
  }
  
  //Memoization 
  //Top-down: 재귀 호출로 구현
  int memo[100];
  int fibonacci(int n) {
  	if (n <= 1) {
  		return n;
  	} else {
  		if (memo[n] > 0) {
  			return memo[n];
  		}
  		memo[n] = fibonacci(n-1) + fibonacci(n-2);
  		return memo[n];
  	}
  }
  
  //Bottom-up: for문으로 구현
  int d[100];
  int fibonacci(int n) {
      d[0] = 0;
      d[1] = 1;
  	for(int i = 2; i <= n; i++) {
  		d[i] = d[i-1] + d[i-2];
  	}
  	return d[n];
  }
  ```



## 문제 풀이 전략

- 문제에서 구하려고 하는 답을 문장으로 나타냄
  - memo[i] = i 번째 피보나치 수 (보통 memo -> d 또는 dp로 표현)
- 그 문장에 나와있는 변수의 개수만큼 메모하는 배열을 만듦
  - top-down인 경우에는 재귀 호출의 인자의 개수
- 문제를 작은 문제로 나누고, 수식을 이용해서 문제를 표현
  - d[i] = d[i-1] + d[i-2]





[출저: code.plus]