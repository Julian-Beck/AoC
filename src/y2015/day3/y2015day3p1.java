package y2015.day3;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

class Tuple {
    public int x;
    public int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class y2015day3p1 {
    private static String readInput() {
        String line = "";
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay3.txt"))) {
            line = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    private static boolean containsInList (ArrayList<Tuple> list, Tuple t) {
        for (Tuple tuple : list) {
            if (tuple.x == t.x && tuple.y == t.y) return true;
        }
        return false;
    }

    public static int solution() {
        String input = readInput();
        ArrayList<Tuple> visited = new ArrayList<Tuple>();
        int x = 0;
        int y = 0;
        visited.add(new Tuple(x, y));
        for (char c : input.toCharArray()) {
            switch (c) {
                case '^': y++; break;
                case 'v': y--; break;
                case '>': x++; break;
                case '<': x--; break;
            }
            Tuple newTuple = new Tuple(x, y);
            if (!containsInList(visited, newTuple)) visited.add(newTuple);
        }

        return visited.size();
    }
}
