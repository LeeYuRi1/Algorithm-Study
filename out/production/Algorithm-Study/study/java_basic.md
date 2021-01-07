# java 기초 정리

codeplus 강의



## 입/출력

- **Scanner**

  - 입력을 편하게 받을 수 있음

    ```java
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) { //hasNextInt: 입력받을 수 있는 자료형인지
    	sum += sc.nextInt(); //nextInt: 정수를 입력받음
    }
    ```

  - nextInt()와 nextLine()을 연속으로 쓸 경우 중간에 sc.nextLine(); 추가해야함



- **BufferedReader**

  - Scanner는 느린 경우가 많음. 입력이 많은 경우에 BufferedReader사용

    ```java
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    String line = bf.readLine();
    String[] line = bf.readLine().split(" "); //공백을 기준으로 자름
    int n = Integer.parseInt(bf.readLine());
    ```

  - read와 readLine만 있기 때문에 정수는 파싱해야함

  - throws IOException 처리 해주기



- **StringTokenizer**

  - 문자열을 토큰으로 잘라야 할 때 편함

    ```java
    StringTokenizer st = new StringTokenizer(line, ","); 
    // 구분자 지정 생략하면 공백이나 탭이 기본 구분자
    
    while (st.hasMoreTokens()) { 
    	sum += Integer.valueOf(st.nextToken()); 
    }
    ```

  - hasMoreTokens(): StringTokenizer객체에서 다음에 읽어들일 token이 있으면 true, 없으면 false를 return

  - nextToken(): StringTokenizer객체에서 다음 토큰을 읽어옴



- **StringBuilder**

  - 출력해야 하는 것이 많은 경우 사용

  - StringBuilder를 이용해 문자열을 만들고 출력

    ```java
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
    	sb.append(i + "\n");
    }
    System.out.print(sb);
    ```



## Collections

- **ArrayList**

  - 배열과 비슷하지만 크기를 변경할 수 있음

    ```java
    //빈 ArrayList 생성
    ArrayList<Integer> a = new ArrayList<Integer>(); 
    //크기가 정해진 ArrayList생성
    ArrayList<Integer> b = new ArrayList<Integer>(40); 
    ```

  - add, clear, contains, get, isEmpty, remove, set, toArray

  - 정렬시 Collections.sort(a);

  - 배열과 비슷하기 때문에 중간에 삽입 삭제 하는 것은 O(N)이 걸림

  - ArrayList는 그래프 문제의 인접 리스트를 만들 때 가장 많이 사용



- **LinkedList**
  - 이중 연결 리스트



- **Stack**

  - 한쪽 끝에서만 자료를 넣고 뺄 수 있는 자료구조

  - 마지막으로 넣은 것이 가장 먼저 나옴: Last In First Out(LIFO)

  - push, pop, top(peek), empty, size

    ```java
    Stack<Integer> stack = new Stack<>();
    stack.push(num);
    ```



- **Set**

  - 인터페이스
  - 중복된 원소를 포함하지 않음
  - add, clear, contains(있는지 없는지), isEmpty, remove, size, toArray(배열로 변환)
  - HashSet, TreeSet, LinkedHashSet이 있음

  1. HashSet

     - 해시테이블을 이용해서 구현

     - 삽입/삭제/제거 연산의 시간 복잡도가 O(1)

     - 순서가 보장되지 않음

       ```java
       HashSet<Integer> d = new HashSet<Integer>();
       ```

  2. TreeSet

     - 이진 검색 트리(레드 블랙 트리)를 이용해서 구현되어 있음

     - 삽입/삭제/제거 연산의 시간 복잡도가 O(logN)

     - 순서가 보장됨(입력으로 넣은 순서 x)

       ```java
       TreeSet<Integer> d = new TreeSet<Integer>();
       ```

  3. LinkedHashSet

     - 해시테이블과 연결리스트를 이용해서 구현되어 있음

     - 삽입/삭제/제거 연산의 시간 복잡도가 O(1)

     - 추가한 순서가 보장됨

       ```java
       LinkedHashSet<Integer> d = new LinkedHashSet<Integer>();
       ```

  - 일반적인 경우에는 HashSet, 순서가 중요한 경우에는 TreeSet, 입력으로 넣은 순서가 중요한 경우에는 LinkedHashSet을 사용



- **Map**

  - 인터페이스

  - 중복된 Key를 포함하지 않음

  - Key-Value 쌍을 이룸

  - clear, containsKey(key가 들어있는지 확인), containsValue(value가 들어있는지 확인), entrySet(key, value 쌍을 이용한 쌍을 만듦), get(key에 해당하는 value를 return), isEmpty, keySet(key를 이용해서 set을 만듦), put(key에 해당하는 value를 넣음), remove, size(key의 크기)

  - HashMap, TreeMap, LinkedHashMap이 있음

    ```java
    HashMap<String, Integer> map = new HashMap<>();
    
    // map에 들어있는 값 순회
    for (Map.Entry<String, Integer> entry: map.entrySet()) {
    	String key = entry.getKey();
    	Integer value = entry.getValue();
    	if (value == 3) {
    		list.add(key);
    	}
    }
    ```



- **Queue**

  - 한쪽 끝에서만 자료를 넣고 다른 한쪽 끝에서만 뺄 수 있는 자료구조
  - 먼저 넣은 것이 가장 먼저 나옴: First In First Out(FIFO)
  - push, pop, front, empty, size
  - 인터페이스
  - 구현한 클래스로 ArrayDeque, LinkedList, PriorityQueue가 있음

  

- **PriorityQueue**

  - 우선순위 큐

  - 큐에 들어있는 것 중에서 가장 우선순위가 높은 것부터 pop

  - 흔히 최대힙이나 최소힙으로 구현

    ```java
    // 가장 작은 것부터 순차적으로 나옴
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); 
    queue.offer(input);
    queue.remove();
    ```

  - 최대힙은 compare 사용

