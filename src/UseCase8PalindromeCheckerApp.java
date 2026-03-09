public class UseCase8PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        String word = "level";
        Node head = null;

        // Convert string to linked list
        for (int i = 0; i < word.length(); i++) {
            head = insertAtEnd(head, word.charAt(i));
        }

        if (isPalindrome(head)) {
            System.out.println(word + " is a Palindrome (Linked List)");
        } else {
            System.out.println(word + " is Not a Palindrome");
        }
    }

    // Insert node at end
    static Node insertAtEnd(Node head, char data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    // Check palindrome
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find middle using fast/slow pointers
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        // Compare halves
        Node p1 = firstHalf, p2 = secondHalf;
        boolean result = true;
        while (p2 != null) {
            if (p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: Restore original list
        slow.next = reverse(secondHalf);

        return result;
    }

    static Node reverse(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
