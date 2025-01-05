package y2015.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class y2015day9p1 {
    private static HashMap<String, HashMap<String, Integer>> readInputs(){
        HashMap<String, HashMap<String, Integer>> cities = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay9.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(" ");
                String city1 = parts[0];
                String city2 = parts[2];
                int distance = Integer.parseInt(parts[4]);

                if (!cities.containsKey(city1)) {
                    cities.put(city1, new HashMap<>());
                }

                cities .get(city1).put(city2, distance);

                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static ArrayList<String> getDistinceCities(HashMap<String, HashMap<String, Integer>> citiesWithDist) {
        ArrayList<String> cities = new ArrayList<>();
        for (String city : citiesWithDist.keySet()){
            for (String cityDest : citiesWithDist.get(city).keySet()) {
                if (!cities.contains(cityDest)) cities.add(cityDest);
            }
            if (!cities.contains(city)) cities.add(city);
        }
        return cities;
    }

    private static int fac(int x) {
        int res = 1;
        for (int i = x; i > 1; i--) {
            res *= i;
        }
        return res;
    }

    private static boolean isValid(String comb) {
        String check = "";
        for (int i = 0; i < comb.length(); i++) {
            String temp = "" + comb.charAt(i);
            if (!check.contains(temp)) check += temp;
            else return false;
        }
        return true;
    }

    private static ArrayList<String[]> getAllCombinations (ArrayList<String> cities) {
        int size = cities.size();

        ArrayList<String[]> combinations = new ArrayList<>();

        ArrayList<String> combsAsNumber = new ArrayList<>();
        for (int i = 0; i < Math.pow(size, size); i++){
            String formatting = "%" + size + "s";
            String num = String.format(formatting, Integer.toString(i, size)).replace(" ", "0");
            if (isValid(num)) combsAsNumber.add(num);
        }

        for (String combAsNumber : combsAsNumber) {
            String[] comb = new String[size];
            for (int i = 0; i < size; i++) {
                int n = Integer.parseInt(String.valueOf(combAsNumber.charAt(i)));
                comb[i] = cities.get(n);
            }
            combinations.add(comb);
        }
        return combinations;
    }

    public static int solution() {
        HashMap<String, HashMap<String, Integer>> citiesWithDist = readInputs();
        ArrayList<String> cities = getDistinceCities(citiesWithDist);

        ArrayList<String[]> combs = getAllCombinations(cities);

        ArrayList<Integer> sums = new ArrayList<>();
        for (String[] comb : combs) {
            int sum = 0;
            for (int i = 0; i < comb.length-1; i++) {
                String currCity = comb[i];
                String nextCity = comb[i+1];
                if (citiesWithDist.containsKey(currCity) && citiesWithDist.get(currCity).containsKey(nextCity)) {
                    sum += citiesWithDist.get(currCity).get(nextCity);
                } else if (citiesWithDist.containsKey(nextCity) && citiesWithDist.get(nextCity).containsKey(currCity)) {
                    sum += citiesWithDist.get(nextCity).get(currCity);
                } else {
                    sum = 0;
                    break;
                }
            }
            if (sum != 0) sums.add(sum);
        }
        return Collections.min(sums);
    }
}
