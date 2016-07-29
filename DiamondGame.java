import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by agrawaay on 7/29/2016.
 */
public class DiamondGame {
    public static void main(String args[]) {

        PlayGame();

    }
    public static class Cards {
        ArrayList<Integer> cards = new ArrayList<>();
        Cards() {
            for(int i = 2;i < 15;i++) {
                cards.add(i);
            }
        }


    }
    public  static int getCardFromBanker(Cards banker) {
        Random random = new Random();
        int card = banker.cards.get(random.nextInt(banker.cards.size()));
        return card;
    }
    public static void PlayGame() {
        Cards player1 = new Cards();
        Cards computer = new Cards();
        Cards banker = new Cards();

        int diamondCard = 0;
        int player1Gain = 0;
        int computerGain = 0;
        int userbid;
        int compbid;

         for(int j = 0;j < 13;j++) {
            diamondCard = getCardFromBanker(banker);
            updateCards(diamondCard,banker);

            System.out.println(diamondCard);
            System.out.println(player1.cards);
            userbid = userInput();
            updateCards(userbid,player1);
            compbid = compInput(diamondCard);
            updateCards(compbid,computer);
            updateGain(userbid,compbid,diamondCard,player1Gain,computerGain);

        }
        evaluateResult(player1Gain,computerGain);


    }

    private static void evaluateResult(int player1Gain, int computerGain) {
        if(player1Gain > computerGain)
            System.out.println("player1 Wins");
        else if (player1Gain == computerGain)
            System.out.println("TIE");
        else
            System.out.println("computer Wins");
    }

    private static void updateGain(int userbid, int compbid, int diamondCard, int player1Gain, int computerGain) {
        if(userbid > compbid) {
            player1Gain += diamondCard;
        } else if(userbid == compbid) {
            player1Gain += diamondCard/2;
            computerGain += diamondCard/2;
        } else
            computerGain += diamondCard;
    }


    private static void updateCards(int card, Cards player ) {
        int index = player.cards.indexOf(card);
        player.cards.remove(index);
    }


    private static int compInput(int diamondCard) {
        return diamondCard;
    }

    private static int userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }



}
