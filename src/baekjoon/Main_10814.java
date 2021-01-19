package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Person implements Comparable<Person> {
    int age;
    String name;
    int join;

    Person(int age, String name, int join) {
        this.age = age;
        this.name = name;
        this.join = join;
    }

    @Override
    public int compareTo(Person that) {
        if (this.age < that.age) {
            return -1;
        } else if (this.age == that.age) {
            if (this.join < that.join) {
                return -1;
            } else if (this.join == that.join) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Main_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] a = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            a[i] = new Person(Integer.parseInt(input[0]), input[1], i);
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (Person p : a) {
            sb.append(p.age + " " + p.name + "\n");
        }
        System.out.println(sb);
    }
}
