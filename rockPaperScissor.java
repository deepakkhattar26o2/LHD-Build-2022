import java.util.Random;
import java.util.Scanner;
public class rockPaperScissor {
    public static void compChoice(int computerInput){
        if (computerInput == 0) {
            System.out.println("Computer choice: Rock");
        } else if (computerInput == 1) {
            System.out.println("Computer choice: Paper");
        } else {
            System.out.println("Computer choice: Scissors");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean matchOver = false;
        while(!matchOver)
        {
            System.out.print("Enter 0 for Rock, 1 for Paper, 2 for Scissor: ");
            int userInput = sc.nextInt();
            Random random = new Random();
            int computerInput = random.nextInt(3);

            if (userInput == computerInput) {
                compChoice(computerInput);
                System.out.println("Draw");
            } else if (userInput == 0 && computerInput == 2 || userInput == 1 && computerInput == 0
                    || userInput == 2 && computerInput == 1) {
                compChoice(computerInput);
                System.out.println("You Win!");
                matchOver = true;
            } else {
                compChoice(computerInput);
                System.out.println("You Lose!");
                matchOver = true;
            }
        }
    }
}
