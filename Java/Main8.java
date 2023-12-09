import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("String: ");
        String input = scanner.nextLine();
        String reversedS = reverse(input);
        System.out.println("Reversed String: " + reversedS);
        scanner.close();
    }

    private static String reverse(String str) {
        var reversed = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
