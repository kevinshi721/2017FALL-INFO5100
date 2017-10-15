import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private ArrayList<String> words;
    private String secretWord;
    private ArrayList<Character> correntList = new ArrayList<Character>();
    private ArrayList<Character> wrongList = new ArrayList<Character>();

    private int maxGuessChances = 8;
    private String[][] hangmanFigures = new String[][]{
            new String[]{
                    " ___________",
                    "|          |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|          |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|          |",
                    "|       ---",
                    "|",
                    "|",
                    "|",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|          |",
                    "|       --- ---",
                    "|",
                    "|",
                    "|",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|          |",
                    "|       --- ---",
                    "|         / ",
                    "|        /  ",
                    "|",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|          |",
                    "|       --- ---",
                    "|         /  \\",
                    "|        /    \\",
                    "|",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|          |",
                    "|       --- ---",
                    "|         /  \\",
                    "|        /    \\",
                    "|      --",
                    "|__________________"
            }, new String[]{
                    " ___________",
                    "|          |",
                    "|          O",
                    "|          |",
                    "|       --- ---",
                    "|         /  \\",
                    "|        /    \\",
                    "|      --      --",
                    "|__________________"
            },
    };

    public Hangman(ArrayList<String> words) {
        this.words = words;
    }

    private void chooseWord() {
        this.secretWord = words.get(new Random().nextInt(this.words.size()));
    }

    private void handleGuess() {
        if (wrongList.size() == maxGuessChances) {
            gameOver();
        }
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.matches("[a-zA-Z]")
                || correntList.contains(input.charAt(0))
                || wrongList.contains(input.charAt(0))) {
            System.out.print("Please input your guess: ");
            input = scanner.nextLine().toLowerCase();
        }
        if (secretWord.contains(input)) {
            correntList.add(input.charAt(0));
        } else {
            wrongList.add(input.charAt(0));
        }
    }

    private boolean gameWon() {
        for (char c : secretWord.toCharArray()) {
            if (!correntList.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private void gameOver() {
        System.out.println("You lose!");
        System.exit(0);
    }

    private void displayWord() {
        System.out.print("The secret word is: ");
        for (char c : secretWord.toCharArray()) {
            if (correntList.contains(c)) {
                System.out.print(c);
            } else {
                System.out.print('-');
            }
        }
        System.out.println();
    }

    private void displayGameStatus() {
        System.out.printf("%d chances remaining", maxGuessChances - wrongList.size());
        if (wrongList.size() > 0) {
            System.out.print(", wrong answers are: ");
            for (Character c : wrongList) {
                System.out.printf("%s ", c);
            }
        }
        System.out.println();
    }

    private void printHangman() {
        for (String s : hangmanFigures[wrongList.size()]) {
            System.out.println(s);
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void playGame() {
        chooseWord();
        while (!gameWon()) {
            clearConsole();
            System.out.println("Welcome to the Hangman game!");
            printHangman();
            displayGameStatus();
            displayWord();
            handleGuess();
        }
        System.out.println("You win!");
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("java");
        words.add("scala");
        words.add("python");
        new Hangman(words).playGame();
    }
}
