import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "radar";  // string to check
        Stack<Character> stack = new Stack<>();

        // Push all characters into the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        // Pop characters to form reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare original and reversed
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome (stack based)");
        } else {
            System.out.println(word + " is Not a Palindrome");
        }
    }
}