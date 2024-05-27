package task1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input a string: ");
        String string = in.nextLine();
        in.close();

        string = string.replaceAll("[^0-9]", "");

        if (string.length() == 0) {
            System.out.println(0);
        } else {
            String[] chars = string.split("");
            int[] digits = Arrays.stream(chars).mapToInt(Integer::parseInt).toArray();
            int result = IntStream.of(digits).sum();
            System.out.println(Arrays.toString(digits));
            System.out.println(result);
        }
    }
}