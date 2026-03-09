import java.util.Stack;

class PalindromeChecker {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push characters
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare with original
        for (int i = 0; i < normalized.length(); i++) {
            if (stack.pop() != normalized.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        String word = "Level";

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(word);

        if (result) {
            System.out.println("\"" + word + "\" is a Palindrome (OO service)");
        } else {
            System.out.println("\"" + word + "\" is Not a Palindrome");
        }
    }
}