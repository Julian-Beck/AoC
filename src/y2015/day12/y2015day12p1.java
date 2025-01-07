package y2015.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2015day12p1 {
    private static String readInputs(){
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay12.txt"))) {
            String line = br.readLine();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static ArrayList<String> getAllNumbersFromInput(String input) {
        ArrayList<String> ret = new ArrayList<>();

        String temp = "";
        for (char c : input.toCharArray()) {
            int i = (int)c;
            if ((i > 47 && i < 58) || i == 45) temp += c + "";
            else if (!temp.isEmpty()){
                ret.add(temp);
                temp = "";
            }
        }

        return ret;
    }

    public static int solution() {
        String input = readInputs();

        ArrayList<String> listOfNumbers = getAllNumbersFromInput(input);

        return listOfNumbers.stream().mapToInt(Integer::parseInt).sum();
    }
}
