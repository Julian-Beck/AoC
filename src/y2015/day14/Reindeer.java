package y2015.day14;

public class Reindeer {
    private int speed;
    private int duration;
    private int rest;

    private int r_time;
    private int d_time;
    private int distance;
    boolean inRest;

    int points;

    public Reindeer(int speed, int duration, int rest) {
        this.speed = speed;
        this.duration = duration;
        this.rest = rest;
        distance = 0;
        r_time = 0;
        d_time = 0;
        points = 0;
    }

    public Reindeer(String reindeer) {
        String[] args = reindeer.toLowerCase().split(" ");
        this.speed =  Integer.parseInt(args[3]);
        this.duration = Integer.parseInt(args[6]);
        this.rest = Integer.parseInt(args[13]);
        distance = 0;
        r_time = 0;
        d_time = 0;
    }

    public void next() {
        if (this.duration == d_time || r_time == this.rest) { inRest = !inRest; r_time = 0; d_time = 0;}
        if (!inRest) {
            this.distance += speed;
            this.d_time++;
        } else {
            r_time++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public int getPoints() {
        return points;
    }

    public void leading() {
        points++;
    }
}
