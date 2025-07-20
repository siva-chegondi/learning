
public class Practice {

    public static void main(String ...args) {

        System.out.println(isBalanced("{}{{}}{{}}"));
        System.out.println(isBalanced("}"));
    }

    private static boolean isBalanced(String input) {

        int count = input.length();
        Stack stack = new Stack(count);
        for(char c: input.toCharArray()) {

            if (c == '{') {
                stack.push(c);
            } else if (c == '}' && !stack.isEmpty() && stack.getTop() == '{') {
                stack.pop();
            } else {
                break;
            }
            count--;
        }

        return count == 0 && stack.isEmpty();
    }

    static class Stack {
        int top = -1;
        char[] eles;

        Stack(int size) {
            eles = new char[size];
        }

        void push(char ele) {
            eles[++top] = ele;
        }

        char pop() {
            return eles[top--];
        }

        boolean isEmpty() {
            return top == -1;
        }

        char getTop() {
            return eles[top];
        }
    }
}
