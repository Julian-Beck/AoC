package y2015.day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class y2015day1p2 {
    private static char[] readInput() {
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay1.txt"))) {
             return br.readLine().toCharArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new char[0];
    }

    public static int solution() {
        char[] input = readInput();
        int cnt = 0;
        int floor = 0;
        for (char c : input) {
            if (c == '(') {
                floor++;
            } else {
                floor--;
            }
            cnt++;
            if (floor == -1) {
                return cnt;
            }
        }
        return cnt;
    }
}
