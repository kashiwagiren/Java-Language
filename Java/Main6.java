import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        boolean isPalindrome = checkPalindrome(input);
        if(isPalindrome) {
            System.out.println("String is palindrome.");
        } else {
            System.out.println("String is not palindrome.");
        }
        scanner.close();
    }

    public static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right));
            return false;
        }
        left++;
        right--;
        return true;
    }
}
