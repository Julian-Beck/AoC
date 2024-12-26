package y2015.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

enum InstructType {
    TURN_ON,
    TURN_OFF,
    TOGGLE
}

class Instruct {
    InstructType type;
    int x1;
    int y1;
    int x2;
    int y2;

    public Instruct(InstructType type, int x1, int y1, int x2, int y2) {
        this.type = type;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class y2015day6p1 {
    private static boolean[][] lights = new boolean[1000][1000];

    private static ArrayList<Instruct> readInput() {
        ArrayList<Instruct> instructions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay6.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] splittedInstruction = line.split(" ");

                InstructType type;
                if (splittedInstruction[0].equals("toggle")) type = InstructType.TOGGLE;
                else if (splittedInstruction[1].equals("off")) type = InstructType.TURN_OFF;
                else type = InstructType.TURN_ON;

                String[] instructStart = splittedInstruction[splittedInstruction.length - 3].split(",");
                String[] instructEnd = splittedInstruction[splittedInstruction.length - 1].split(",");

                int x1 = Integer.parseInt(instructStart[0]);
                int y1 = Integer.parseInt(instructStart[1]);
                int x2 = Integer.parseInt(instructEnd[0]);
                int y2 = Integer.parseInt(instructEnd[1]);

                instructions.add(new Instruct(type, x1, y1, x2, y2));
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructions;
    }

    private static void applyInstruct(Instruct instruct) {
        InstructType type = instruct.type;
        for (int y = instruct.y1; y <= instruct.y2; y++) {
            for (int x = instruct.x1; x <= instruct.x2; x++) {
                lights[y][x] = type == InstructType.TOGGLE ? !lights[y][x] : type == InstructType.TURN_ON;
            }
        }
    }

    private static int getLightsOn() {
        int cnt = 0;
        for (int y = 0; y < lights.length; y++) {
            for (int x = 0; x < lights[y].length; x++) {
                if (lights[y][x]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int solution() {
        ArrayList<Instruct> instructions = readInput();

        for (Instruct instruct : instructions) {
            applyInstruct(instruct);
        }

        return getLightsOn();
    }
}
