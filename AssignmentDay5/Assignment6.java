package AssignmentDay5;

public class Assignment6 implements CharSequence {
    private String original;

    public Assignment6(String str) {
        this.original = str;
    }

    public int length() {
        return original.length();
    }

    public char charAt(int index) {
        return original.charAt(original.length() - 1 - index);
    }

    public CharSequence subSequence(int start, int end) {
        StringBuilder sub = new StringBuilder();
        for (int i = start; i < end; i++) {
            sub.append(charAt(i));
        }
        return sub.toString();
    }

    public String toString() {
        return new StringBuilder(original).reverse().toString();
    }

    public static void main(String[] args) {
        Assignment6 b = new Assignment6("hello");
        System.out.println("Length: " + b.length());
        System.out.println("CharAt(1): " + b.charAt(1));
        System.out.println("SubSequence(1, 4): " + b.subSequence(1, 4));
        System.out.println("ToString: " + b.toString());
    }
}
