package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 일찍 끝나는 회의부터 배정함
    @Override
    public int compareTo(Meeting that) {
        if (this.end < that.end) {
            return -1;
        } else if (this.end == that.end) {
            return Integer.compare(this.start, that.start);
        } else {
            return 1;
        }
    }
}

public class Main_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(meetings);
        int result = 1;
        int end = meetings[0].end;
        for (int i = 1; i < n; i++) {
            if (end <= meetings[i].start) {
                result++;
                end = meetings[i].end;
            }
        }
        System.out.println(result);
    }
}
