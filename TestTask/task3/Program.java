package task3;

import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;

public class Program{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "ibm866");

        System.out.print("Input a string: ");
        String string = in.nextLine();
        in.close();

        System.out.println(string);

        String[] words = string.split(" ");
        Pattern pattern = Pattern.compile("[АЕЁИОУЫЭЮЯаеёиоуыэюя]");


        for (int i = 0; i < words.length; i++) {
            if (pattern.matcher(words[i].substring(0, 1)).matches()) {
                if (words[0].length() == 1){
                    words[i] = words[i].substring(0, 1).toUpperCase();
                } else {
                    words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
                }
            }
        }

        Pair[] pairs = new Pair[words.length];

        for (int i = 0; i < words.length; i++) {
            pairs[i] = new Pair(words[i], Math.toIntExact(pattern.matcher(words[i]).results().count()));
        }

        Arrays.sort(pairs, Pair::compare);

        for (int i = 0; i < words.length; i++) {
            System.out.println(pairs[i].word);
        }
    }
}