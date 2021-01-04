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

