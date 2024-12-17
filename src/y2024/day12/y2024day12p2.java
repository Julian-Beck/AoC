package y2024.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class y2024day12p2 {
    private static ArrayList<ArrayList<Character>> garden;
    private static void readInput(){
        garden = new ArrayList<ArrayList<Character>>();
        ArrayList<String> ret = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2024/inputs/inputDay12.txt"))) {
            String line = br.readLine();
            while (line != null) {
                garden.add(new ArrayList<Character>());
                for (int i = 0; i < line.length(); i++){
                    garden.getLast().add(line.charAt(i));
                }
                line = br.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Character getPlantAt(Position p){
        return garden.get(p.y).get(p.x);
    }

    private static void removePlants(ArrayList<Position> plants){
        for (Position plant : plants) {
            garden.get(plant.y).set(plant.x, '.');
        }
    }

    private static ArrayList<Position> getNeighbours(Position p, char plant){
        ArrayList<Position> ret = new ArrayList<>();
        for (int y = p.y-1; y < p.y+2; y++) {
            if (y == p.y || y < 0 || y >= garden.size()) continue;
            if (getPlantAt(new Position(p.x, y)) == plant) ret.add(new Position(p.x, y));
        }
        for (int x = p.x-1; x < p.x+2; x++) {
            if (x == p.x || x < 0 || x >= garden.getFirst().size()) continue;
            if (getPlantAt(new Position(x, p.y)) == plant) ret.add(new Position(x, p.y));
        }
        return ret;
    }

    private static boolean listContainsPosition(ArrayList<Position> list, Position p){
        for (Position pos : list){
            if (pos.equals(p)) return true;
        }
        return false;
    }

    private static ArrayList<Position> getConnectedPlants(Position pos){
        ArrayList<Position> visited = new ArrayList<>();
        ArrayList<Position> queue = new ArrayList<>();

        visited.add(pos);
        queue.add(pos);

        char type = getPlantAt(pos);
        while (!queue.isEmpty()){
            Position current = queue.removeFirst();
            for (Position neighbour : getNeighbours(current, type)){
                if (!listContainsPosition(visited, neighbour)){
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        removePlants(visited);

        return visited;
    }

    private static int getPerimeter(ArrayList<Position> plants){
        int perimeter = 0;
        return perimeter;
    }


    private static void printGarden(ArrayList<ArrayList<Character>> garden){
        for (ArrayList<Character> row : garden){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static long solution() {
        readInput();
        int price = 0;

        for (int y = 0; y < garden.size(); y++){
            for (int x = 0; x < garden.get(y).size(); x++){
                if (garden.get(y).get(x) != '.'){
                    ArrayList<Position> plants= getConnectedPlants(new Position(x, y));
                    int area = plants.size();
                    int perimeter = getPerimeter(plants);
                    price += area * perimeter;
                }
            }
        }

        return price;
    }
}
