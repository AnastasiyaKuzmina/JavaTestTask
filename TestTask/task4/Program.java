package task4;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String[][] digits = new String[10][];

        digits[0] = new String[] {"* * *  ", "*   *  ", "*   *  ", "*   *  ", "* * *  "};
        digits[1] = new String[] {"    *  ", "  * *  ", "*   *  ", "    *  ", "    *  "};
        digits[2] = new String[] {"* * *  ", "    *  ", "* * *  ", "*      ", "* * *  "};
        digits[3] = new String[] {"* * *  ", "    *  ", "* * *  ", "    *  ", "* * *  "};
        digits[4] = new String[] {"*   *  ", "*   *  ", "* * *  ", "    *  ", "    *  "};
        digits[5] = new String[] {"* * *  ", "*      ", "* * *  ", "    *  ", "* * *  "};
        digits[6] = new String[] {"* * *  ", "*      ", "* * *  ", "*   *  ", "* * *  "};
        digits[7] = new String[] {"* * *  ", "    *  ", "   *   ", "  *    ", " *     "};
        digits[8] = new String[] {"* * *  ", "*   *  ", "* * *  ", "*   *  ", "* * *  "};
        digits[9] = new String[] {"* * *  ", "*   *  ", "* * *  ", "    *  ", "* * *  "};

        Scanner in = new Scanner(System.in);

        System.out.print("Input a number: ");
        String string = in.nextLine();
        in.close();

        string = string.replaceAll("[^0-9]", "");

        if (string.length() != 0) {
            int[] numbers = Arrays.stream(string.split("")).mapToInt(Integer::parseInt).toArray();
            int maxNumber = Arrays.stream(numbers).max().getAsInt();

            for(int i = 0; i < digits[0].length; i++) {
                for(int j : numbers) {
                    if (j == maxNumber) {
                        System.out.print(digits[j][i].replace('*', Character.forDigit(j, 10)));
                    } else {
                        System.out.print(digits[j][i]);
                    }
                }
                System.out.println();
            }
        }
    }
}