package y2015.day13;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class y2015day13p1 {
    private static ArrayList<String> readInputs(){
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay13.txt"))) {
            String line = "";
            while ((line=br.readLine())!=null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static int calcSeating(HashMap<String, Integer> values, ArrayList<String> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += (i+1 < arr.size()) ? values.get(arr.get(i)+ " " + arr.get(i+1)) : values.get(arr.get(i) + " " + arr.get(0));
            sum += (i+1 < arr.size()) ? values.get(arr.get(i+1)+ " " + arr.get(i)) : values.get(arr.get(0) + " " + arr.get(i));
        }
        return sum;
    }

    public static ArrayList<ArrayList<String>> permutations(ArrayList<String> items, ArrayList<String> permutation, int size) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        /* permutation stack has become equal to size that we require */
        if(permutation.size() == size) {
            /* print the permutation */
            // System.out.println(Arrays.toString(permutation.toArray(new String[0])));
            res.add(new ArrayList<>(permutation));
        }

        /* items available for permutation */
        String[] availableItems = items.toArray(new String[0]);
        for(String i : availableItems) {
            /* add current item */
            permutation.add(i);

            /* remove item from available item set */
            items.remove(i);

            /* pass it on for next permutation */
            res.addAll(new ArrayList<ArrayList<String>>(permutations(items, permutation, size)));

            /* pop and put the removed item back */
            items.add(permutation.getLast());
            permutation.remove(permutation.getLast());
        }
        return res;
    }

    private static int calcHappiness(ArrayList<String> input){
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();
        names.add("Myself"); // Part 2

        for (String line : input) {
            var args = line.split(" ");
            String first = args[0];
            if (!names.contains(first)) {names.add(first);}
            String second = args[10].substring(0, args[10].length() - 1);
            int happiness = args[2].equals("lose") ? -Integer.parseInt(args[3]) : Integer.parseInt(args[3]);

            map.put(first+" "+second, happiness);
        }

        // Part 2
        for (String name : names) {
            map.put(name+" Myself", 0);
            map.put("Myself " + name, 0);
        }

        int max = 0;
        ArrayList<ArrayList<String>> perms = permutations(names, new ArrayList<String>(), names.size());
        for (ArrayList<String> perm : perms) {
            int v = calcSeating(map, perm);
            System.out.println(perm.toString() + " -> " + v);
            max =  Math.max(v, max);
        }
        return max;
    }

    public static int solution() {
        ArrayList<String> input = readInputs();

        return calcHappiness(input);
    }
}
