public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama"; // string to check

        // Normalize string: remove spaces & convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        if (isPalindrome(normalized, 0, normalized.length() - 1)) {
            System.out.println("\"" + input + "\" is a Palindrome (Case-insensitive, spaces ignored)");
        } else {
            System.out.println("\"" + input + "\" is Not a Palindrome");
        }
    }

    // Recursive function
    static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true; // base condition
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start + 1, end - 1);
    }
}
