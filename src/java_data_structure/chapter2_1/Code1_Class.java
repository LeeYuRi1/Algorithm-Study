package java_data_structure.chapter2_1;

public class Code1_Class {
    public static void main(String[] args) {

        Person1 first;
        first = new Person1();

        first.name = "John";
        first.number = "1234243223";

        System.out.println("First is " + first.name + " with number " + first.number);

        Person1[] members = new Person1[100];
        members[0] = first;
        members[1] = new Person1();
        members[1].name = "David";
        members[1].number = "463464643";

        System.out.println("Second is " + members[1].name + " with number " + members[1].number);
    }
}
