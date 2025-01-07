package y2015.day10;

import java.io.BufferedReader;
import java.io.FileReader;

public class y2015day10p2 {
    private static String readInputs(){
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay10.txt"))) {
            String line = br.readLine();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String seeAndLook(String input) {
        String ret = "";
        char[] arr = input.toCharArray();
        char currDigit = arr[0];

        int tempSum = 1;
        for (int i = 1; i < input.length(); i++) {
            if (arr[i] == currDigit) tempSum++;
            else {
                ret += String.valueOf(tempSum);
                ret += currDigit;
                currDigit = arr[i];
                tempSum = 0;
            }
        }
        return ret;
    }

    public static int solution() {
        String input = readInputs();

        return 0;
    }
}
