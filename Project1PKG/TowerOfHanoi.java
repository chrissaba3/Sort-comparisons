package Project1PKG;
import java.time.Instant;
import java.time.Duration;

public class TowerOfHanoi {
    public static void main(String [] args){
        Instant start= Instant.now();           //timer initialize
        Instant end = Instant.now();            //timer initialize for the for loop
    for(int n=1; Duration.between(start, end).toSeconds()<600; n++) {   //n increments and completes algorithm until timer exceeds 600 seconds, or 10 mins
        start = Instant.now();

        Tower(n, 'A', 'C', 'B');
        end = Instant.now();
        System.out.println( "Number of Disks: "+ n + "for time: "+ Duration.between(start, end));
    }
    }

    static void Tower(int n, char from_rod, char to_rod, char aux_rod){ //recursive Tower function takes from to and aux rod
        if(n == 1){
            return;
        }
        Tower(n-1, from_rod, aux_rod, to_rod);      //switches aux rod and to rod
        Tower(n-1, aux_rod, to_rod, from_rod);      //switches aux rod and from rod
    }   //two recursive calls combined give a O(2^n) complexity
}
