package task5;

import java.util.*;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) {
        Item[] items = {new Item(5, 3), new Item(10, 5), new Item(6, 4), new Item(5, 2)};
      //  Item[] items = {new Item(3, 1), new Item(4, 6), new Item(5, 4), new Item(8, 7), new Item(9, 6)};
        int safeVolume = 13;

        Selection[][] selections = new Selection[items.length + 1][safeVolume + 1];

        for (int i = 0; i <= safeVolume; i++) {
            selections[0][i] = new Selection(new int[]{}, 0, 0);
        }

        for (int i = 1; i <= items.length; i++) {
            for (int j = 0; j <= safeVolume; j++) {
                if (items[i - 1].volume > j) {
                    selections[i][j] = selections[i - 1][j];
                }
                else {
                    int newValue = selections[i - 1][j - items[i - 1].volume].totalValue + items[i - 1].value;
                    if (selections[i - 1][j].totalValue > newValue) {
                        selections[i][j] = selections[i - 1][j];
                    }
                    else {
                        selections[i][j] = new Selection(IntStream.concat(IntStream.of(selections[i - 1][j - items[i - 1].volume].selectedItems), IntStream.of(new int[]{i - 1})).toArray(), newValue, selections[i - 1][j - items[i - 1].volume].totalVolume + items[i - 1].volume);
                    }
                }
            }
        }

        System.out.println("Selected items (starts from 0): " + Arrays.toString(selections[items.length][safeVolume].selectedItems));
        System.out.println("Total value: " + selections[items.length][safeVolume].totalValue);
        System.out.println("Total volume: " + selections[items.length][safeVolume].totalVolume);
    }
}