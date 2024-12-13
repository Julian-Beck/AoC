package y2024.day12;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position add(Position p) {
        return new Position(this.x + p.x, this.y + p.y);
    }

    public boolean equals(Position p) {
        return this.x == p.x && this.y == p.y;
    }
}
