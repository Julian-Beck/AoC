package y2015.day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class y2015day2p1 {
    private static int readInput() {
        int sum = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay2.txt"))) {
            String line = br.readLine();
            while (line != null){
                Integer[] temp = new Integer[3];
                String[] split = line.split("x");
                for (int i = 0; i < 3; i++) {
                    temp[i] = Integer.parseInt(split[i]);
                }
                int first = temp[0]*temp[1];
                int second = temp[0]*temp[2];
                int third = temp[1]*temp[2];
                sum += 2*first + 2*second + 2*third + Math.min(first, Math.min(second, third));

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
