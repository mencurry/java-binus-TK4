import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // establish the dictionary for all three levels, words are taken from Scrabble US dictionary at wordfinderx.com
    private static final String[] dictionaryLevel1 = {"tilted","titled","tilde", "tiled", "title", "deil", "deli", "delt", "diel", "diet", "dite", "edit", "idle", "lied", "tide", "tide", "lite", "tile", "tilt", "del", "die", "dit", "eld", "led", "lid", "ted", "lei", "let", "lie", "lit", "tel", "tet", "tie", "til", "tit"};
    private static final String[] dictionaryLevel2 = {"encase", "seance", "seneca", "ances", "canes", "cease", "cense", "scena", "scene", "aces", "acne", "cane", "cans", "case", "cees", "scan", "anes", "ease", "esne", "naes", "sane", "seen", "sene", "ace", "can", "cee", "sac", "sec", "ane", "ens", "nae", "nee", "sae", "san", "sea", "see", "sen"};
    private static final String[] dictionaryLevel3 = {"honker", "krone", "heron", "honer", "hoke", "honk", "hork", "okeh", "keno", "kern", "kore", "hern", "hero", "hoer", "hone", "horn,", "reno", "ken", "kor", "oke", "hen", "her", "hoe", "hon", "noh", "rho", "eon", "ern", "nor", "one", "ore", "roe"};

    // establish variables that will be used
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<String> userAnswersArray = new ArrayList<>();
    private static int overallScore = 0;
    private static int currentScore = 0;
    private static boolean status = true;

    public static void main(String[] args) {
        // check status first, if its true then the program runs else it stops
        while (status) {
            // print welcome text for users
            System.out.println("Coepoe Word Puzzle");
            System.out.println("==================\n");
            System.out.println("Rules : ");
            System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters");
            System.out.println("2. Each level, you have 10 chances to answer correctly");
            System.out.println("3. To get through to next level you have to score 70 point each level\n");

            // start level 1 with array of dictionaryLevel1 selected
            System.out.println("Level 1");
            System.out.println("d         e         t         t         l         i");
            Level(dictionaryLevel1);

            // start level 2 with array of dictionaryLevel2 selected
            if (currentScore >= 70) {
                currentScore = 0;
                userAnswersArray.clear();
                System.out.println("\nLevel 2");
                System.out.println("s         e         c         a         e         n");
                Level(dictionaryLevel2);
            }

            // start level 3 with array of dictionaryLevel3 selected
            if (currentScore >= 70) {
                currentScore = 0;
                userAnswersArray.clear();
                System.out.println("\nLevel 3");
                System.out.println("h         k         r         n         e         o");
                Level(dictionaryLevel3);
            }

            // check if currentScore is less than 70, user lose, else they win
            if (currentScore <= 70) {
                System.out.println("\nYou lose!! Try again..");
                System.out.print("Do you want to retry?  [Y/T] ");
                String retry = input.nextLine();
                if (retry.equalsIgnoreCase("t")){
                    status = false;
                } else if (retry.equalsIgnoreCase("y")) {
                    status = true;
                } else {
                    status = false;
                }
            } else {
                System.out.println("\nOverall score : " + overallScore);
                System.out.println("You win!!");
                System.out.print("\nDo you want to retry?  [Y/T] ");
                String retry = input.nextLine();
                if (retry.equalsIgnoreCase("t")){
                    status = false;
                } else if (retry.equalsIgnoreCase("y")) {
                    status = true;
                } else {
                    status = false;
                }
            }
        }
    }

    private static void Level(String[] dictionaryLevel1) {
        String userAnswer;
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "> Your Answer : ");
            userAnswer = input.nextLine().trim().toLowerCase();
            if (validateAnswer(dictionaryLevel1, userAnswer)) {
                currentScore += 10;
                System.out.println("#Right. Score = " + currentScore);
            }
        }
        System.out.println("You had answered 10 times with " + (currentScore / 10) + " right answers..\n");
        overallScore += currentScore;
        System.out.println("Correct answers : ");
        printArray(dictionaryLevel1);
    }

    private static void printArray(String[] dictionaryLevel) {
        int currentIdx = 0;
        while (currentIdx < dictionaryLevel.length) {
            for (int i = 0; i < 10 && currentIdx < dictionaryLevel.length; i++) {
                System.out.print(dictionaryLevel[currentIdx] + ", ");
                currentIdx++;
            }
            System.out.println();
        }
    }

    private static boolean validateAnswer(String[] dictionaryLevel, String userAnswer) {
        if (userAnswer.length() < 3 || userAnswer.length() > 6) {
            System.out.println("Your answer should be min 3 characters and max 6 characters!");
        }
        else if (Arrays.asList(dictionaryLevel).contains(userAnswer) && !userAnswersArray.contains(userAnswer)) {
            userAnswersArray.add(userAnswer);
            return true;
        } else if (userAnswersArray.contains(userAnswer)) {
            System.out.println("you have already entered this word, you can't!");
            return false;
        } else if (!Arrays.asList(dictionaryLevel).contains(userAnswer)) {
            System.out.println("Sorry, that word doesn't exist in our dictionary!");
            return false;
        }
        return false;
    }
}
