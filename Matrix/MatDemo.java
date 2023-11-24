package Matrix;
import java.util.Random;

class Matrix {
   int row, col;
   int[][] matrix;

   // constructor
   Matrix(int r, int c) {
      this.row = r;
      this.col = c;
      this.matrix = new int[r][c];
   }

   public void setMatrix() {
      Random random = new Random();
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            matrix[i][j] = random.nextInt(10);
         }
      }
   }

   public void printMatrix() {
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println("");
      }
   }

   // Matrix Multiplication
   public Matrix Matmultipilcation(Matrix other) {
      if (this.col != other.row) {
         throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication");
      }

      Matrix result = new Matrix(this.row, other.col);

      for (int i = 0; i < this.row; i++) {
         for (int j = 0; j < other.col; j++) {
            int sum = 0;
            for (int k = 0; k < this.col; k++) {
               sum += this.matrix[i][k] * other.matrix[k][j];
            }
            result.matrix[i][j] = sum;
         }
      }
      return result;
   }

   // Matrix Addition
   public Matrix MatAddition(Matrix other) {
      if (this.row != other.row || this.col != other.col) {
         throw new IllegalArgumentException("Incompatible matrix dimensions");
      }
      Matrix result = new Matrix(this.row, this.col);

      for (int i = 0; i < this.row; i++) {
         for (int j = 0; j < this.col; j++) {
            result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
         }
      }
      return result;

   }

   // Matrix Transpose
   public Matrix MatTranspose() {
      Matrix result = new Matrix(this.col, this.row);

      for (int i = 0; i < this.row; i++) {
         for (int j = 0; j < this.col; j++) {
            result.matrix[j][i] = this.matrix[i][j];
         }
      }

      return result;
   }
}

public class MatDemo {
   public static void main(String[] args) {
      Matrix matrix1 = new Matrix(5, 5);
      Matrix matrix2 = new Matrix(5, 5);
      matrix1.setMatrix();
      matrix2.setMatrix();

      System.out.println("Matrix-1:");
      matrix1.printMatrix();
      System.out.println("Matrix-2:");
      matrix2.printMatrix();

      Matrix mul_ans = matrix1.Matmultipilcation(matrix2);
      System.out.println("Multiplication:");
      mul_ans.printMatrix();

      Matrix add_ans = matrix1.MatAddition(matrix2);
      System.out.println("Addition:");
      add_ans.printMatrix();

      Matrix trans_ans = matrix2.MatTranspose();
      System.out.println("Trasnpose:");
      trans_ans.printMatrix();

      matrix1.toString();
   }
}