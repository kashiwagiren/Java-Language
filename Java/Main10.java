import java.util.*;

public class Main10 {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Radius: ");
            int rad = scanner.nextInt();
            double c = 2 * Math.PI * rad;
            double area = Math.PI * rad * rad;
            System.out.println("Circumference: " + c);
            System.out.println("Area: " + area);
        }
    }
}
