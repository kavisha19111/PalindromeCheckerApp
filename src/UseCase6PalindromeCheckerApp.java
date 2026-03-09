import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";  // string to check

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue characters in queue & push characters to stack
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            queue.add(c); // enqueue
            stack.push(c); // push
        }

        boolean isPalindrome = true;

        // Compare dequeue (queue) vs pop (stack)
        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (Queue + Stack)");
        } else {
            System.out.println(word + " is Not a Palindrome");
        }
    }
}