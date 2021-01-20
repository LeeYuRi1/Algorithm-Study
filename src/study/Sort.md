# 정렬

- 선택 정렬, 버블 정렬, 삽입 정렬, 퀵 정렬, 힙 정렬, 병합 정렬, ...
- 정렬은 O(NlogN)이 걸리는 정렬을 사용하는 것으로 함(퀵, 힙, 병합)
- 직접 구현하는 것 보다는 array.sort, collections.sort를 사용하는 것이 좋음



### Comparable vs Comparator

- compareTo 메소드를 작성하면 됨
  - this < that: -1
  - this == that: 0
  - this > that: 1

```java
class Point implements Comparable<Point> {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point that) {
        if (this.x < that.x) {
            return -1;
        } else if (this.x == that.x) {
            if (this.y < that.y) {
                return -1;
            } else if (this.y == that.y) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

//main
//Comparable
Arrays.sort(a);

//Comparator
Arrays.sort(a, new Comparator<Point>() {
	public int compare(Point p1, Point p2) {
		return p1.compareTo(p2);
	}
});
```

- comparable은 compareTo를 구현하는데, natural 순서를 정의(ex.문자열의 natural 순서는 사전순)
- comparator는 다른 순서로 정렬하고 싶을 때 사용(ex.문자열을 길이 순으로 정렬하고 싶을 때)



### stable sorting

- 안정 정렬
- 같은 것이 있는 경우에 정렬하기 전의 순서가 유지되는 정렬 알고리즘
- ex) 7!, 5^, 2^, 5! - 번호가 증가하는 순서로 정렬했을 때, 5^와 5!의 순서
- 시간복잡도가 NlogN인 정렬 알고리즘 중에는 병합 정렬(Merge Sort)가 있음





[출저: code.plus]