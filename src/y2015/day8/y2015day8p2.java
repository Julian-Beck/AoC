package y2015.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2015day8p2 {
    private static ArrayList<String> readInputs(){
        ArrayList<String> ret = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay8.txt"))) {
            String line = br.readLine();
            while (line != null) {
                ret.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static int getEscaped(String input) {
        int ret = 0;
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (inputArray[i] == '\\' || inputArray[i] == '\"') ret++;
            ret++;
        }
        return ret+2;
    }

    public static int solution() {
        ArrayList<String> inputs = readInputs();

        int original = inputs.stream().mapToInt(String::length).sum();
        int escaped = inputs.stream().mapToInt(y2015day8p2::getEscaped).sum();

        return escaped - original;
    }
}
