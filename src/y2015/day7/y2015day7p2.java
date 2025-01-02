package y2015.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class y2015day7p2 {
    private static ArrayList<Node> nodes = new ArrayList<>();

    private static ArrayList<Node> readInputs(){
        ArrayList<Node> nodes = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/y2015/inputs/inputDay7.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] splittedNode = line.split(" ");
                Node node = new Node();
                if (splittedNode.length == 3) {
                    node.op = operation.ASSIGN;
                    String value = splittedNode[0];
                    if (value.matches("[0-9]+")) {
                        node.input1Value = Integer.parseInt(value);
                    } else {
                        node.input1 = value;
                    }
                    node.output = splittedNode[2];
                } else if (splittedNode.length == 4) {
                    node.op = operation.NOT;
                    String value = splittedNode[1];
                    if (value.matches("[0-9]+")) {
                        node.input1Value = Integer.parseInt(value);
                    } else {
                        node.input1 = value;
                    }
                    node.output = splittedNode[3];
                } else {
                    String value1 = splittedNode[0];
                    if (value1.matches("[0-9]+")) {
                        node.input1Value = Integer.parseInt(value1);
                    } else {
                        node.input1 = value1;
                    }
                    String value2 = splittedNode[2];
                    if (value2.matches("[0-9]+")) {
                        node.input2Value = Integer.parseInt(value2);
                    } else {
                        node.input2 = value2;
                    }
                    node.output = splittedNode[4];
                    switch (splittedNode[1]) {
                        case "AND":
                            node.op = operation.AND;
                            break;
                        case "OR":
                            node.op = operation.OR;
                            break;
                        case "LSHIFT":
                            node.op = operation.LSHIFT;
                            break;
                        case "RSHIFT":
                            node.op = operation.RSHIFT;
                            break;
                    }
                }
                nodes.add(node);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodes;
    }

    private static int not(int value) {
        String bin = String.format("%16s", Integer.toBinaryString(value)).replace(' ', '0');
        String ret = "";
        for (char c : bin.toCharArray()) {
            if (c == '0') ret += 1;
            else ret += 0;
        }
        return Integer.parseInt(ret, 2);
    }

    private static int and (Node node) {
        int value1 = getValue(node);
        int value2 = getValue2(node);
        String bin1 = String.format("%16s", Integer.toBinaryString(value1)).replace(' ', '0');
        String bin2 = String.format("%16s", Integer.toBinaryString(value2)).replace(' ', '0');
        String ret = "";
        for (int i = 0; i < bin1.length(); i++) {
            if (bin1.charAt(i) == '1' && bin2.charAt(i) == '1') ret += '1';
            else ret += '0';
        }
        int result = Integer.parseInt(ret, 2);
        return result;
    }

    private static int or (Node node) {
        int value1 = getValue(node);
        int value2 = getValue2(node);
        String bin1 = String.format("%16s", Integer.toBinaryString(value1)).replace(' ', '0');
        String bin2 = String.format("%16s", Integer.toBinaryString(value2)).replace(' ', '0');
        String ret = "";
        for (int i = 0; i < bin1.length(); i++) {
            if (bin1.charAt(i) == '1' || bin2.charAt(i) == '1') ret += '1';
            else ret += '0';
        }
        return Integer.parseInt(ret, 2);
    }

    private static int lshift (Node node) {
        int value = getValue(node);
        int offset = getValue2(node);
        String bin1 = String.format("%16s", Integer.toBinaryString(value)).replace(' ', '0');
        String ret = "";
        for (int i = 0; i < bin1.length(); i++) {
            if (i+offset < bin1.length()) ret += bin1.charAt(i+offset);
            else ret += '0';
        }
        return Integer.parseInt(ret, 2);
    }

    private static int rshift (Node node) {
        int value = getValue(node);
        int offset = getValue2(node);
        String bin1 = String.format("%16s", Integer.toBinaryString(value)).replace(' ', '0');
        String ret = "";
        for (int i = 0; i < bin1.length(); i++) {
            if (i < offset) ret += '0';
            else ret += bin1.charAt(i-offset);
        }
        return Integer.parseInt(ret, 2);
    }

    private static int applyOperation(Node node) {
        int ret = -1;

        switch (node.op) {
            case operation.ASSIGN:
                ret = getValue(node);
                break;
            case operation.NOT:
                ret = not(getValue(node));
                break;
            case operation.AND:
                ret = and(node);
                break;
            case operation.OR:
                ret = or(node);
                break;
            case operation.LSHIFT:
                ret = lshift(node);
                break;
            case operation.RSHIFT:
                ret = rshift(node);
                break;
        }
        return ret;
    }

    private static int getValue(Node node) {
        if (node.input1Value != -1) return node.input1Value;
        else {
            Node prevNode = getNodeByOutput(node.input1);
            node.input1Value = applyOperation(prevNode);
            return node.input1Value;
        }
    }

    private static int getValue2(Node node) {
        if (node.input2Value != -1) return node.input2Value;
        else {
            Node prevNode = getNodeByOutput(node.input2);
            node.input2Value = applyOperation(prevNode);
            return node.input2Value;
        }
    }

    private static Node getNodeByOutput(String output) {
        return nodes.stream().filter(n -> n.output.equals(output)).findFirst().orElse(null);
    }

    public static int solution () {
        nodes = readInputs();

        int valueA = applyOperation(getNodeByOutput("a"));

        nodes = readInputs();

        getNodeByOutput("b").input1Value = valueA;

        return applyOperation(getNodeByOutput("a"));
    }
}
