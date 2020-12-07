package Project1PKG;
import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class StrassenMethodMatrix {
    public static void main(String[] args) {

        Random r = new Random();
        int Low = 1;
        int High = 10;
        Instant start = Instant.now();
        Instant end = Instant.now();
        for (int n = 2; Duration.between(start, end).toSeconds() < 600; n = n * 2) {    //timed for loop for 10 mins, increasing problem size by 2x
            int[][] a = new int[n][n];
            int[][] b = new int[n][n];  //initialize 2 arrays for multiplying

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = r.nextInt(High - Low) + Low;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = r.nextInt(High - Low) + Low;
                }
            }
            int[][] arr = new int[n][n];
            start = Instant.now();
            arr = strassen(a, b);
            end = Instant.now();
            System.out.print("Current size array: " + n + " * " + n);
            System.out.println(" --- " + "Total time for multiplication: " + Duration.between(start, end));
        }
    }





    public static int [][] strassen(int [][] a, int [][] b) { //recursive strassen method
        int n = a.length;
        int [][] result = new int[n][n];

        if(n <= 100){           //When array size is 100 or less, use classical method IJK to calculate it faster
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        result[i][j] = result[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
            return result;
        }
        else {
            int [][] A11 = new int[n/2][n/2];
            int [][] A12 = new int[n/2][n/2];
            int [][] A21 = new int[n/2][n/2];
            int [][] A22 = new int[n/2][n/2];

            int [][] B11 = new int[n/2][n/2];
            int [][] B12 = new int[n/2][n/2];
            int [][] B21 = new int[n/2][n/2];
            int [][] B22 = new int[n/2][n/2];

            divide(a, A11, 0 , 0);
            divide(a, A12, 0 , n/2);
            divide(a, A21, n/2, 0);
            divide(a, A22, n/2, n/2);

            divide(b, B11, 0 , 0);
            divide(b, B12, 0 , n/2);
            divide(b, B21, n/2, 0);
            divide(b, B22, n/2, n/2);

            int [][] P1 = strassen(add(A11, A22), add(B11, B22));
            int [][] P2 = strassen(add(A21, A22), B11);
            int [][] P3 = strassen(A11, sub(B12, B22));
            int [][] P4 = strassen(A22, sub(B21, B11));
            int [][] P5 = strassen(add(A11, A12), B22);
            int [][] P6 = strassen(sub(A21, A11), add(B11, B12));
            int [][] P7 = strassen(sub(A12, A22), add(B21, B22));

            int [][] C11 = add(sub(add(P1, P4), P5), P7);
            int [][] C12 = add(P3, P5);
            int [][] C21 = add(P2, P4);
            int [][] C22 = add(sub(add(P1, P3), P2), P6);

            copy(C11, result, 0 , 0);
            copy(C12, result, 0 , n/2);
            copy(C21, result, n/2, 0);
            copy(C22, result, n/2, n/2);
        }
        return result;
    }

    public static int [][] add(int [][] A, int [][] B) { //array add method
        int n = A.length;

        int [][] result = new int[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                result[i][j] = A[i][j] + B[i][j];

        return result;
    }

    public static int [][] sub(int [][] A, int [][] B) {       //array subtract method
        int n = A.length;

        int [][] result = new int[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                result[i][j] = A[i][j] - B[i][j];

        return result;
    }

    public static void divide(int[][] p1, int[][] c1, int iB, int jB) {     //split array into smaller sizes
        for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
            for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
            {
                c1[i1][j1] = p1[i2][j2];
            }
    }

    public static void copy(int[][] c1, int[][] p1, int iB, int jB) {       //copy array to
        for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
            for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++) {
                p1[i2][j2] = c1[i1][j1];
            }
    }






}
