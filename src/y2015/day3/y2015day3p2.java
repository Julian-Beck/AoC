package y2015.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class y2015day3p2 {
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

    private static String getInstructions(String instruct, boolean isSanta) {
        String ret = "";
        int i = isSanta ? 0 : 1;
        for (; i < instruct.length(); i+=2){
            ret+= instruct.charAt(i);
        }
        return ret;
    }

    private static ArrayList<Tuple> getVisited (ArrayList<Tuple> visited, String instruct) {
        int x = 0;
        int y = 0;
        if (!containsInList(visited, new Tuple(x, y))) visited.add(new Tuple(x, y));
        for (char c : instruct.toCharArray()) {
            switch (c) {
                case '^': y++; break;
                case 'v': y--; break;
                case '>': x++; break;
                case '<': x--; break;
            }
            Tuple newTuple = new Tuple(x, y);
            if (!containsInList(visited, newTuple)) visited.add(newTuple);
        }
        return visited;
    }

    public static int solution() {
        String input = readInput();
        String santa = getInstructions(input, true);
        String roboSanta = getInstructions(input, false);

        ArrayList<Tuple> visited = new ArrayList<Tuple>();
        visited = getVisited(visited, santa);
        visited = getVisited(visited, roboSanta);
        return visited.size();
    }
}
