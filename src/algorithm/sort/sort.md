## 정렬

- Bubble sort, Insertion sort, selection sort - simple, slow
- Quick sort, merge sort, heap sort - fast
- radix sort - O(N)



### selection sort

- 각 루프마다 최대 원소를 찾아서 최대 원소와 맨 오른쪽 원소를 교환함. 맨 오른쪽 원소를 제외함
  하나의 원소만 남을 때까지 루프 반복

- 시간복잡도: O(n^2)

![selection sort](https://user-images.githubusercontent.com/33548856/96506099-07c7ec80-1292-11eb-9c97-d32c7ea610bd.JPG)



### Bubble sort

- 최대 원소를 맨 오른쪽으로 보내고 제외함(selection sort와 유사)
  현재 원소와 다음 원소를 비교하여 현재 원소가 더 크면 자리를 바꿈
- 시간복잡도: O(n^2)

![1603126765941](https://user-images.githubusercontent.com/33548856/96506231-3fcf2f80-1292-11eb-9852-9e76b2672265.png)



### Insertion sort 삽입정렬

- 데이터가 하나만 있을때 정렬된 상태. 하나씩 추가하면서 정렬된 상태로 만드는 것
- k-1개의 데이터들이 정렬이 되어있을 때 k번째 데이터를 넣음
  앞에서부터 검사하면 모든 데이터들을 검사해야함. 뒤에서부터 검사하면 앞쪽 데이터는 검사하지 않음 - 뒤에서부터 검사하는 것이 효율적
- 시간복잡도: O(n^2)

![1603128053883](https://user-images.githubusercontent.com/33548856/96506313-61c8b200-1292-11eb-9d11-da6ce8805aeb.png)

![1603128267874](https://user-images.githubusercontent.com/33548856/96506337-6ab98380-1292-11eb-9b2e-491c82e34cee.png)



### Merge sort 합병정렬

- 분할정복법 사용
  분할: 해결하고자 하는 문제를 작은 크기의 동일한 문제들로 분할
  정복: 각각의 작은 문제를 순환적(recursion)으로 해결
  합병: 작은 문제의 해를 합하여(merge) 원래 문제에 대한 해를 구함

![1604486430885](C:\Users\LEE\AppData\Roaming\Typora\typora-user-images\1604486430885.png)



### Quick sort 빠른 정렬

- 분할정복법 사용
- pivot을 정해서 pivot보다 작은 값, 큰 값으로 분할
- 합병은 필요 없음

![1604486149178](C:\Users\LEE\AppData\Roaming\Typora\typora-user-images\1604486149178.png)







출처: 인프런 - 영리한 프로그래밍을 위한 알고리즘 강좌 (권오흠 교수님)
