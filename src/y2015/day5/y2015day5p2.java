package y2015.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2015day5p2 {
    private static ArrayList<String> readInput() {
        ArrayList<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay5.txt"))) {
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static boolean getStringWithout(String str, String toRemove) {
        String out = str.replace(toRemove, "..");
        int cnt = 0;
        for (int i = 0; i < out.length(); i++) {
            if (out.charAt(i) == '.') cnt++;
        }
        return cnt > 3;
    }

    private static boolean checkForPairWithoutOverlaping (String str) {
        for (int i = 1; i < str.length(); i++) {
            String pair = str.substring(i-1, i+1);
            if (getStringWithout(str, pair)) return true;
        }
        return false;
    }

    private static boolean containsSandwich (String str) {
        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-2)) return true;
        }
        return false;
    }

    private static boolean isNice(String strToCheck) {
        return checkForPairWithoutOverlaping(strToCheck) && containsSandwich(strToCheck);
    }

    public static int solution() {
        ArrayList<String> lines = readInput();
        int niceStrings = 0;
        for (String line : lines) {
            if (isNice(line)) niceStrings++;
        }
        return niceStrings;
    }
}
