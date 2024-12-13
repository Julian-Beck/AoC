import y2024.day1.day1p1;
import y2024.day1.day1p2;
import y2024.day2.day2p1;
import y2024.day2.day2p2;
import y2024.day11.day11p1;
import y2024.day11.day11p2;
import y2024.day12.day12p1;
import y2024.day12.day12p2;

public class Main {
    public static void main(String[] args) {
        // PART 1
        long startTime = System.nanoTime();

        // Define the day
        String result1 = String.valueOf(day12p1.solution());

        long endTime = System.nanoTime();
        long duration1 = (endTime - startTime) / 1_000_000;

        // PART 2
        startTime = System.nanoTime();

        // Define the day
        String result2 = String.valueOf(day12p2.solution());

        endTime = System.nanoTime();
        long duration2 = (endTime - startTime) / 1_000_000;

        // Print results
        System.out.format("%15s | %20s\n", "Part 1", "Part 2");
        System.out.format("%15s | %20s\n", result1, result2);
        System.out.format("%13dms | %18dms\n", duration1, duration2);
    }
}