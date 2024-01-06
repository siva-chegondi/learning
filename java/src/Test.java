import java.util.StringJoiner;

public class Test {

    public static void main(String []args) {
        String a = new String("abc"); // creates in Heap Space
        String b = a.intern(); // creates in String Constant Pool
        String c = b.intern(); // refers to SCP

        System.out.println(a == b); // false
        System.out.println(b == c); // same memory reference


        StringJoiner sj1 = new StringJoiner(" ");
        sj1.add("Geeks").add("For").add("Geeks");
        System.out.println(sj1);

        StringJoiner sj2 = new StringJoiner(":");
        sj2.add("Siva").add("Testing");
        System.out.println(sj2);

        System.out.println(sj2.merge(sj1));
    }
}
