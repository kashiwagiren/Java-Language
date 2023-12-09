public class NaturalNum {
    
    public static void main(String args[]) {
        int N = 10;
		int sum = 0;
		System.out.print("First " + N + " Numbers = ");

		for (int i = 1; i <= N; i++) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println();
		System.out.println("Sum of first " + N + " Natural Number = " + sum);
    }
}
