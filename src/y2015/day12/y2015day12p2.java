package y2015.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2015day12p2 {
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
        ArrayList<String> tempRet = new ArrayList<>();

        boolean inObject = false;
        ArrayList<String> tempObjects = new ArrayList<>();
        ArrayList<Boolean> tempHasRed = new ArrayList<>();

        String temp = "";
        for (char c : input.toCharArray()) {
            int i = (int)c;
            if (i == 125) {
                inObject = tempHasRed.size() > 1;
                if (!tempHasRed.getLast()) ret.addAll(tempRet);
                else tempRet.clear();
                tempHasRed.removeLast();
            }
            if (inObject && tempHasRed.getLast()) continue;

            if ((i > 47 && i < 58) || i == 45) temp += c;
            else if (!temp.isEmpty()){
                tempRet.add(temp);
                temp = "";
            }

            if (i == 123) {
                inObject = true;
                tempObjects.add("");
                tempHasRed.add(false);
                ret.addAll(tempRet);
                tempRet.clear();
            }
            if (inObject) tempObjects.set(tempObjects.size() - 1, tempObjects.getLast() + c);
            if (inObject && tempObjects.getLast().contains("red")) tempHasRed.set(tempHasRed.size() - 1, true);
        }
        if (!tempRet.isEmpty()) ret.addAll(tempRet);
        return ret;
    }

    public static int solution() {
        String input = readInputs();

        ArrayList<String> listOfNumbers = getAllNumbersFromInput(input);

        return listOfNumbers.stream().mapToInt(Integer::parseInt).sum();
    }
}
