import y2015.day12.y2015day12p1;
import y2015.day12.y2015day12p2;
import y2015.day13.y2015day13p1;
import y2015.day14.y2015day14p1;
import y2015.day14.y2015day14p2;

public class Main {
    public static void main(String[] args) {
        // PART 1
        long startTime = System.nanoTime();
        // Define the day
        String result1 = String.valueOf(y2015day14p1.solution());

        long endTime = System.nanoTime();
        long duration1 = (endTime - startTime) / 1_000_000;

        // PART 2
        startTime = System.nanoTime();

        // Define the day
        String result2 = String.valueOf(y2015day14p2.solution());
        //String result2 = String.valueOf(2);

        endTime = System.nanoTime();
        long duration2 = (endTime - startTime) / 1_000_000;

        // Print results
        System.out.format("%15s | %20s\n", "Part 1", "Part 2");
        System.out.format("%15s | %20s\n", result1, result2);
        System.out.format("%13dms | %18dms\n", duration1, duration2);
    }
}