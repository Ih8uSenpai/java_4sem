package prac1;

import java.util.*;
import java.util.function.Consumer;
public class Main {

static String find_str(String[] rows){

    int max = -1;
    String s = "no answer";
    for (int i = 0; i < rows.length; i++) {
        if (uniq_els(rows[i]) > max)
        {
            max = uniq_els(rows[i]);
            s = rows[i];
        }
    }
    return s;
}

static int uniq_els(String row){
    short[] table = new short[10000];
    int counter = 0;
    for (int i = 0; i < row.length(); i++){
        if (table[(int)row.charAt(i)] == 0)
        {
            table[(int)row.charAt(i)] = 1;
            counter++;
        }
    }
    return counter;
}
    public static void main(String[] args) {
        String[] rows = new String[3];
        rows[0] = "sssssssss";
        rows[1] = "stroka";
        rows[2] = "stqqqq";
        Consumer<String[]> consumer = x -> System.out.println(find_str(x));
        consumer.accept(rows);
    }
}