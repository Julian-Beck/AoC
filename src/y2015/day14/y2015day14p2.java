package y2015.day14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2015day14p2 {
    private static ArrayList<String> readInputs(){
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay14.txt"))) {
            String line = "";
            while ((line=br.readLine())!=null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static int calcDist(String reindeer, int time) {
        String[] args = reindeer.toLowerCase().split(" ");
        int speed =  Integer.parseInt(args[3]);
        int duration = Integer.parseInt(args[6]);
        int rest = Integer.parseInt(args[13]);

        return calc(speed, duration, rest, time);
    }

    private static int calc(int speed, int dur, int rest, int time) {
        int dist = 0;
        int sprint = 0;
        boolean r = false;
        int r_time = 0;

        for (int i = 0; i < time; i++) {
            if (sprint == dur || r_time == rest) { r = !r; r_time = 0; sprint = 0; i--;}
            else if (!r) {
                dist += speed;
                sprint++;
            } else {
                r_time++;
            }
        }
        return dist;
    }


    public static int solution() {
        int time = 2503;
        ArrayList<String> input = readInputs();

        ArrayList<Reindeer>  reindeers = new ArrayList<>();
        for (String reindeer : input) {
            reindeers.add(new Reindeer(reindeer));
        }

        for (int i = 0; i < time; i++) {
            ArrayList<Integer> distances = new  ArrayList<>();
            for (Reindeer reindeer : reindeers) {
                reindeer.next();
                distances.add(reindeer.getDistance());
            }
            int max = 0;
            for (int dist :  distances) {
                max = Math.max(max, dist);
            }
            for (Reindeer reindeer : reindeers) {
                if (max == reindeer.getDistance()) reindeer.leading();
            }
        }
        int winning = 0;
        for (Reindeer reindeer : reindeers) {
            winning = Math.max(winning, reindeer.getPoints());
        }
        return winning;
    }
}