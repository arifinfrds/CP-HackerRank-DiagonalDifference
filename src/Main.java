import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    scanner.nextLine();


    int[][] matrix = new int[n][n];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = scanner.nextInt();
      }
      if (scanner.hasNextLine()) {
        scanner.nextLine();
      }
    }

    if (!isMatrixValid(matrix)) {
      return;
    }

    int diagonalDifference = getDiagonalDifferenceValue(
            getTotalPrimaryDiagonalValue(matrix),
            getTotalSecondaryDiagonalValue(matrix)
    );
    System.out.println(diagonalDifference);
  }

  private static boolean isMatrixValid(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[j].length; j++) {
        return (matrix[i][j] >= -100 && matrix[i][j] <= 100);
      }
    }
    return false;
  }

  private static int getTotalPrimaryDiagonalValue(int[][] matrix) {
    int total = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (i == j) {
          total += matrix[i][j];
        }
      }
    }
    return total;
  }

  private static int getTotalSecondaryDiagonalValue(int[][] matrix) {
    int total = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if ((i + j) == matrix.length - 1) {
          total += matrix[i][j];
        }
      }
    }
    return total;
  }

  private static int getDiagonalDifferenceValue(int primaryDiagonal, int secondaryDiagonal) {
    return Math.abs(primaryDiagonal - secondaryDiagonal);
  }

}
