package y2015.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class y2015day10p1 {
    private static HashMap<String, String> memory = new HashMap<>();

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
        ArrayList<String> temps = new ArrayList<>();
        char[] arr = input.toCharArray();

        char currDigit = arr[0];
        String temp = currDigit + "";
        for (int i = 1; i < input.length(); i++) {
            if (arr[i] == currDigit) temp+=arr[i];
            else {
                temps.add(temp);
                currDigit = arr[i];
                temp = currDigit + "";
            }
        }

        for (String nums : temps) {
            if (memory.containsKey(nums)) {
                ret += memory.get(nums);
            } else {
                String toAdd = "";
                toAdd += String.valueOf(nums.length());
                toAdd += nums;
                ret += toAdd;
                memory.put(nums, toAdd);
            }
        }
        ret += String.valueOf(temp.length());
        ret += currDigit;
        return ret;
    }

    private static void updateMemory() {
        ArrayList<String> keys = new ArrayList<>(memory.keySet());

    }

    public static int solution() {
        String input = readInputs();

        for (int i = 0; i < 50; i++) {
            input = seeAndLook(input);
            System.out.println(i);
        }
        // System.out.println(input);
        return input.length();
    }
}