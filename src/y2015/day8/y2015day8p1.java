package y2015.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2015day8p1 {
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

    private static int getMemory(String input) {
        int ret = 0;
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (inputArray[i] == '\\') {
                if (inputArray[i+1] == 'x') {
                    ret++;
                    i += 3;
                } else {
                    ret++;
                    i++;
                }
            } else ret++;
        }
        return ret-2;
    }

    public static int solution() {
        ArrayList<String> inputs = readInputs();

        int litaral = inputs.stream().mapToInt(String::length).sum();
        int memory = inputs.stream().mapToInt(y2015day8p1::getMemory).sum();

        return litaral - memory;
    }
}
