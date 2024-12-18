package y2015.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;

public class y2015day4 {
    private static String readInput() {
        String line = "";
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay4.txt"))) {
            line = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public static int solution() {
        String input = readInput();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String key = input + Integer.toString(i);
                byte[] hash = md5.digest(key.getBytes());
                String hashAsString  = "";
                for (byte b : hash) {
                    hashAsString += String.format("%02x", b);
                    if (hashAsString.startsWith("000000")) { // change leading zeors for part1/2
                        return i;
                    }
                }
                System.out.format("%s: %s\n", key, hashAsString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
