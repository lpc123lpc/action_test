

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static ArrayList<Item> array = new ArrayList<>();

    public ArrayList<Item> getArray() {
        return array;
    }

    public void getExpression(String line) {
        String newline = line.replaceAll("\\s","");
        if (!newline.startsWith("+") && !newline.startsWith("-")) {
            newline = "+" + newline;
        }
        String regex = "([+-]*)((\\d+)\\*)?x(\\*{2}([+-]?\\d*))?";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(newline);
        while (m.find()) {
            String flag;
            String coe;
            String index;
            if (m.group(1) == null) {
                flag = "+";
            }
            else {
                flag = m.group(1);
            }
            if (m.group(3) == null) {
                coe = "1";
            }
            else {
                coe = m.group(3);
            }
            //System.out.println(m.group(3));
            if (m.group(5) == null) {
                index = "1";
            }
            else {
                index = m.group(5);
            }
            //System.out.println(m.group(5));
            Item item = new Item(flag, coe, index);
            array.add(item);

        }
        array.sort(Item::compareTo);
    }

    public  static void remove() {
        ArrayList<Item> newArray = new ArrayList<>();

        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i).getIndex().equals(array.get(i + 1).getIndex())) {
                array.get(i + 1).addCoe(array.get(i));
            }
            else if (!array.get(i).getCoe().equals(BigInteger.ZERO)
                    && !array.get(i).getIndex().equals(BigInteger.ZERO)) {
                newArray.add(array.get(i));
            }
        }
        int size = array.size();
        if (!array.get(size - 1).getCoe().equals(BigInteger.ZERO)
                && !array.get(size - 1).getIndex().equals(BigInteger.ZERO)) {
            newArray.add(array.get(size - 1));
        }
        array.clear();
        array = newArray;
    }

    public void print() {
        remove();
        if (array.size() == 0) {
            System.out.print("0");
        }
        else {
            for (int i = 0; i < array.size(); i++) {
                if (i == 0) {
                    if (array.get(i).getFlag().equals("-")) {
                        System.out.print("-");
                    }
                }
                else {
                    System.out.print(array.get(i).getFlag());
                }
                array.get(i).print();
            }
        }
    }
}


