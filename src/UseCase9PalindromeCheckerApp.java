public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "deed";  // string to check

        if (isPalindrome(word, 0, word.length() - 1)) {
            System.out.println(word + " is a Palindrome (Recursive)");
        } else {
            System.out.println(word + " is Not a Palindrome");
        }
    }

    // Recursive function
    static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true; // base condition
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start + 1, end - 1); // recursive call
    }
}