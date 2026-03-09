import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray()) {
            if (stack.pop() != c) return false;
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : normalized.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Context
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main App
public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "Madam";

        PalindromeContext context = new PalindromeContext();

        // Choose Stack strategy
        context.setStrategy(new StackStrategy());
        System.out.println("Stack Strategy: " + context.executeStrategy(word));

        // Choose Deque strategy
        context.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy: " + context.executeStrategy(word));
    }
}