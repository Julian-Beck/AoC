package y2015.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2015day2p2 {
    private static int[] remove(int[] arr, int value) {
        int[] newArr = new int[arr.length-1];
        boolean skipped = false;
        for (int i = 0; i < arr.length; i++) {
            if (!skipped && arr[i] == value) {
                skipped = true;
                continue;
            }
            if (skipped) {
                newArr[i-1] = arr[i];
            } else {
                newArr[i] = arr[i];
            }
        }
        return newArr;
    }

    private static int getLowest(int[] arr) {
        int lowest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < lowest) {
                lowest = arr[i];
            }
        }
        return lowest;
    }

    private static int readInput() {
        int sum = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay2.txt"))) {
            String line = br.readLine();
            while (line != null){
                int[] temp = new int[3];
                String[] split = line.split("x");
                for (int i = 0; i < 3; i++) {
                    temp[i] = Integer.parseInt(split[i]);
                }
                int first = temp[0];
                int second = temp[1];
                int third = temp[2];
                int lowest = getLowest(temp);
                int[] tempRemoved = remove(temp, lowest);
                int secondLowest = getLowest(tempRemoved);
                sum += first*second*third + 2*lowest + 2*secondLowest;

                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public static int solution(){
       return readInput();
    }
}
