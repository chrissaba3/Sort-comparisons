package Project1PKG;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;
public class ClassicMatrixMultiplication {
    public static void main(String[] args) {
        Instant start = Instant.now();      //initialize timer variables for the loop
        Instant end = Instant.now();
        for (int n = 2; Duration.between(start, end).toSeconds() < 600; n = n * 2) {        //iterate until algorithm exceeds 10 mins in powers of 2
            int[][] firstMatrix = new int[n][n];
            int[][] secondMatrix = new int[n][n];
            int[][] finalMatrix = new int[n][n];        //create 3 arrays for multiplying
            Random r = new Random();
            int Low = 1;
            int High = 10;      //bounds for random number gen, can change anytime
            System.out.print("Current size: "+ n + " x " + n + " --- ");    //print current size

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    firstMatrix[i][j] = r.nextInt(High - Low) + Low;        //fill first array
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    secondMatrix[i][j] = r.nextInt(High - Low) + Low;       //fill second array
                }
            }

            start = Instant.now();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        finalMatrix[i][j] = finalMatrix[i][j] + firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            end = Instant.now();
            System.out.println("Total time for multiplication: " + Duration.between(start, end));

        }
    }
}