package y2015.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class y2015day5p1 {
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

    private static boolean checkForVocals (String str) {
        String vocals = "aeiou";
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vocals.contains(""+str.charAt(i))) cnt++;

        }
        return 2 < cnt;
    }

    private static boolean checkForPair (String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) return true;
        }
        return false;
    }

    private static boolean containsProhibited (String str) {
        String[] prohibited = new String[]{"ab", "cd", "pq", "xy"};
        for (String s : prohibited) {
            if (str.contains(s)) return true;
        }
        return false;
    }

    private static boolean isNice(String strToCheck) {
        return checkForVocals(strToCheck) && checkForPair(strToCheck) && !containsProhibited(strToCheck);
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
