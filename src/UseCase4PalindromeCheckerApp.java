public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "level";   // the string to check
        char[] letters = word.toCharArray();  // convert to char array

        int start = 0;
        int end = letters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (letters[start] != letters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (char array check)");
        } else {
            System.out.println(word + " is Not a Palindrome");
        }
    }
}