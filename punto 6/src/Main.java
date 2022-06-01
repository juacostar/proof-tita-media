import java.util.*;

public class Main {

    public static int valueOfString(String s){
        int value = 0;
        ArrayList<Character> abecedario = new ArrayList<>();
        abecedario.add('a');
        abecedario.add('b');
        abecedario.add('c');
        abecedario.add('d');
        abecedario.add('e');
        abecedario.add('f');
        abecedario.add('g');
        abecedario.add('h');
        abecedario.add('i');
        abecedario.add('j');
        abecedario.add('k');
        abecedario.add('l');
        abecedario.add('m');
        abecedario.add('n');
        abecedario.add('o');
        abecedario.add('p');
        abecedario.add('q');
        abecedario.add('r');
        abecedario.add('s');
        abecedario.add('t');
        abecedario.add('u');
        abecedario.add('v');
        abecedario.add('w');
        abecedario.add('x');
        abecedario.add('y');
        abecedario.add('z');

        for(char c: s.toCharArray()){
            value += (abecedario.indexOf(c) + 1);
        }
        return value;
    }
    
    public static void main(String[] args) {
        String[] array = {"abc", "ujk", "zzy", "ahj", "aaz", "oip"};
        List<Integer> values = new ArrayList<>();
        Map<Integer, String> valuesWithStrings = new HashMap<>();
        for(String s: array){
            values.add(valueOfString(s));
            valuesWithStrings.put(valueOfString(s), s);
        }
        Collections.sort(values);

       for(Integer i: values) {
           System.out.print(valuesWithStrings.get(i) + ",");
       }
    }
}
