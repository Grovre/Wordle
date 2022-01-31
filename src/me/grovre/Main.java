package me.grovre;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int takenSpotsInGuessLetters = 0;
        char[] correctGuessLetters = new char[5];
        char[] word = getNewWordChars();
        int guessNum = 1;

        System.out.println("Enter guess " + guessNum + ": ");
        while(true && guessNum <= 5) {
            guessNum++;
            char[] guess = getGuess();
            System.out.println("Your guess: "+ Arrays.toString(guess));

            if (Arrays.equals(guess, word)) {
                System.out.println("Your guess is correct!");
                break;
            }

            for(int i = 0; i < word.length; i++) {
                for(int j = 0; j < guess.length; j++) {
                    if(guess[j] == word[i]) {
                        if(i == j) {
                            System.out.println(guess[j] + " is correct and in the right spot");
                        } else {
                            System.out.println(guess[j] + " is correct");
                        }
                    }
                }
            }
            if(guessNum > 5) break;
            System.out.println("Enter guess " + guessNum + ": ");
        }

    }

    // Dynamically created alphabet
    public static char[] getNewWordChars() {
        String[] words = {
                "navel",
                "faker",
                "table",
                "stuff",
                "salty",
                "fates",
                "clown",
                "hints",
                "nanos",
                "flint",
                "twerk",
                "hotel"
        };
        String word = words[((int) (Math.random() * words.length)) + 1];
        return word.toCharArray();
    }

    public static char[] getGuess() {
        String guess = "";
        while (guess.length() != 5) {
            guess = new Scanner(System.in).nextLine();
            if (guess.length() != 5) System.out.println("Your guess can only be 5 letters!");
        }
        return guess.toCharArray();
    }

    public boolean isInArray(char[] array, char letter) {
        for(char l : array) {
            if(l == letter) return true;
        }
        return false;
    }

}
