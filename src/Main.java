//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // MAIN CODE HERE

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time: " + (duration / 1_000_000) + "ms");
    }
}