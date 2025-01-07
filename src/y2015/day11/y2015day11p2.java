package y2015.day11;

import java.io.BufferedReader;
import java.io.FileReader;

public class y2015day11p2 {
    private static String readInputs(){
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay11.txt"))) {
            String line = br.readLine();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static int[] convertStringToIntArray(String input){
        int[] intArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            intArray[i] = (int)input.charAt(i);
        }
        return intArray;
    }

    private static int[] incrementChar(int[] arr, int index){
        if (arr[index]+1 == 123) {
            arr[index] = 97;
            incrementChar(arr, index-1);
        } else {
            arr[index] = arr[index]+1;
        }
        return arr;
    }

    private static boolean isValid(int[] intArr) {
        boolean hasStraight = false;
        for (int i = 0; i < intArr.length-2; i++) {
            if (intArr[i] == intArr[i+1]-1 && intArr[i] == intArr[i+2]-2) {
                hasStraight = true;
                break;
            }
        }

        boolean noIOL = true;
        for (int i = 0; i < intArr.length; i++) {
            int test = intArr[i];
            if (test == 105 || test == 111 || test == 108) {
                noIOL = false;
                break;
            }
        }

        boolean hasTwoPairs = false;
        int cnt = 0;
        for (int i = 0; i < intArr.length-1; i++) {
            if (intArr[i] == intArr[i+1]) {
                cnt++;
                i++;
            }
            if (cnt == 2) {
                hasTwoPairs = true;
                break;
            }
        }
        return hasStraight && noIOL && hasTwoPairs;
    }

    private static String convertToString(int[] arr) {
        String ret = "";
        for (int i : arr) {
            ret += (char)i;
        }
        return ret;
    }

    private static int[] findFirstValid(int[] arr) {
        while(true) {
            arr = incrementChar(arr, arr.length-1);
            if (isValid(arr)) return arr;
        }
    }

    public static String solution(){
        String input = readInputs();
        int[] intArr = convertStringToIntArray(input);
        int[] first = findFirstValid(intArr);
        return convertToString(findFirstValid(first));
    }
}
