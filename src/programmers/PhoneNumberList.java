package programmers;

// 전화번호 목록
public class PhoneNumberList {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println(solution(new String[]{"987987", "87"})); // true - 접두사이므로 중간에 포함된 경우는 아님
    }

    public static boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j])) return false;
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
}
