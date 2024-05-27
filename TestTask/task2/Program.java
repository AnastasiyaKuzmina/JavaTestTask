package task2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList; 

public class Program {
    public static ArrayList<Integer> searchOfPrimes(int n) {
        boolean[] primes = new boolean[n - 1];
        Arrays.fill(primes, true);

        for (int i = 2; i * i <= n; i++) {
            if (primes[i - 2]) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j - 2] = false;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (primes[i - 2]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input a number: ");

        try {
            int number = in.nextInt();
            
            if (number < 2) {
                throw new InputMismatchException();
            }

            ArrayList<Integer> primeNumbers = searchOfPrimes(number);
            System.out.println(primeNumbers.toString());
            ArrayList<Integer> primeFactors = new ArrayList<Integer>();

            for (int i : primeNumbers) {
                while (number % i == 0) {
                    number = number / i;
                    primeFactors.add(i);
                }

                if (number == 1) {
                    break;
                }
            }

            System.out.println(primeFactors.toString());
        } 
        catch (InputMismatchException e) {
            System.out.println("Error! The number that was inputed is either not an integer or less than 2!");
        } 
        finally {
            in.close();
        }
    }
}