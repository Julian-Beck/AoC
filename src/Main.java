import y2015.day3.y2015day3p2;
import y2015.day4.y2015day4;
import y2015.day5.y2015day5p1;
import y2015.day5.y2015day5p2;
import y2015.day6.y2015day6p1;
import y2015.day6.y2015day6p2;
import y2015.day7.y2015day7p1;
import y2015.day7.y2015day7p2;

public class Main {
    public static void main(String[] args) {
        // PART 1
        long startTime = System.nanoTime();

        // Define the day
        String result1 = String.valueOf(y2015day7p1.solution());

        long endTime = System.nanoTime();
        long duration1 = (endTime - startTime) / 1_000_000;

        // PART 2
        startTime = System.nanoTime();

        // Define the day
        String result2 = String.valueOf(y2015day7p2.solution());

        endTime = System.nanoTime();
        long duration2 = (endTime - startTime) / 1_000_000;

        // Print results
        System.out.format("%15s | %20s\n", "Part 1", "Part 2");
        System.out.format("%15s | %20s\n", result1, result2);
        System.out.format("%13dms | %18dms\n", duration1, duration2);
    }
}