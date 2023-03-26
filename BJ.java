import java.util.*;

public class Blackjack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int playerSum = 0;
        int dealerSum = 0;

        // player's first card
        int card1 = rand.nextInt(11) + 1;
        playerSum += card1;
        System.out.println("You drew " + card1);

        // dealer's first card
        int card2 = rand.nextInt(11) + 1;
        dealerSum += card2;
        System.out.println("Dealer drew " + card2);

        // player's second card
        int card3 = rand.nextInt(11) + 1;
        playerSum += card3;
        System.out.println("You drew " + card3);

        // dealer's second card
        int card4 = rand.nextInt(11) + 1;
        System.out.println("Dealer's second card is hidden.");

        // player's turn
        while (true) {
            System.out.println("Your total is " + playerSum + ".");
            System.out.print("Do you want to hit (1) or stay (2)? ");
            int choice = input.nextInt();
            if (choice == 1) {
                int card = rand.nextInt(11) + 1;
                playerSum += card;
                System.out.println("You drew " + card + ".");
                if (playerSum > 21) {
                    System.out.println("You busted! Dealer wins.");
                    return;
                }
            } else if (choice == 2) {
                System.out.println("You chose to stay.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        // dealer's turn
        while (dealerSum < 17) {
            int card = rand.nextInt(11) + 1;
            dealerSum += card;
            System.out.println("Dealer drew " + card + ".");
            if (dealerSum > 21) {
                System.out.println("Dealer busted! You win!");
                return;
            }
        }

        // determine the winner
        System.out.println("Dealer's total is " + dealerSum + ".");
        if (dealerSum > playerSum) {
            System.out.println("Dealer wins!");
        } else if (playerSum > dealerSum) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
