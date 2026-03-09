import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        String word = "A man a plan a canal Panama";
        String normalized = word.replaceAll("\\s+", "").toLowerCase();

        // Measure Stack approach
        long startStack = System.nanoTime();
        boolean stackResult = isPalindromeStack(normalized);
        long endStack = System.nanoTime();

        // Measure Deque approach
        long startDeque = System.nanoTime();
        boolean dequeResult = isPalindromeDeque(normalized);
        long endDeque = System.nanoTime();

        System.out.println("Stack Approach: " + stackResult + ", Time: " + (endStack - startStack) + " ns");
        System.out.println("Deque Approach: " + dequeResult + ", Time: " + (endDeque - startDeque) + " ns");
    }

    static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (stack.pop() != c) return false;
        }
        return true;
    }

    static boolean isPalindromeDeque(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}
