public class Matrices {
    public static void main(String args[]) {
        int[] matrix1 = {1, 3, 4, 2, 4, 3, 3, 4, 5};
		int[] matrix2 = {1, 3, 4, 2, 4, 3, 1, 2, 4};
		int matrix3;

		System.out.println("Sum of 2 Matrices: ");
		for(int i=0; i<=8; i++){
			matrix3 = matrix1[i] + matrix2[i];
			System.out.print(matrix3 + ", ");
		}
    }
}
