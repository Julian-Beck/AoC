import y2024.day1;

public class Main {
    public static void main(String[] args) {
        // PART 1
        long startTime = System.nanoTime();

        // Define the day
        long result1 = day1.p1();

        long endTime = System.nanoTime();
        long duration1 = (endTime - startTime) / 1_000_000;

        // PART 2
        startTime = System.nanoTime();

        // Define the day
        long result2 = day1.p2();

        endTime = System.nanoTime();
        long duration2 = (endTime - startTime) / 1_000_000;

        // Print results
        System.out.format("%15s | %20s\n", "Part 1", "Part 2");
        System.out.format("%15d | %20d\n", result1, result2);
        System.out.format("%13dms | %18dms\n", duration1, duration2);
    }
}