package y2024.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class day2p1 {
    private static ArrayList<String> readInput() {
        ArrayList<String> ret = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2024/inputs/inputDay2.txt"))) {
            String line = br.readLine();
            while (line != null) {
                ret.add(line);
                line = br.readLine();
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }

    private static int[] convertToReport(String rawInput){
        String[] temp = rawInput.split(" ");
        int[] report = new int[temp.length];
        for (int c = 0; c < temp.length; c++) {
            report[c] = (Integer.parseInt(temp[c]));
        }
        return report;
    }

    private static boolean checkForSafe(int[] report) {
        int last = report[0];
        boolean ascending = report[0] < report[1];
        for (int i = 1; i < report.length; i++){
            int curr = report[i];
            int dist = Math.abs(last - curr);
            if (dist != 1 && dist != 2 && dist != 3) { return false; }
            if (ascending && last > curr) { return false; }
            if (!ascending && last < curr) { return false; }
            last = curr;
        }
        return true;
    }

    public static int solution() {
        ArrayList<String> input = readInput();
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            int[] report = convertToReport(input.get(i));
            if (checkForSafe(report)) { sum++; }
        }
        return sum;
    }
}
