/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author HP
 */

//import java.util.ArrayList;

/**
 * Represents the War game, a subclass of Game.
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Wargame with Cards!");

        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        List<PlayingCard> deck = generateDeck();
        Collections.shuffle(deck);

        List<PlayingCard> player1Hand = new ArrayList<>();
        List<PlayingCard> player2Hand = new ArrayList<>();

        // Distribute cards to players
        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) {
                player1Hand.add(deck.get(i));
            } else {
                player2Hand.add(deck.get(i));
            }
        }

        int round = 1;
        int player1Wins = 0;
        int player2Wins = 0;

        System.out.println("Press Enter to start the game...");
        scanner.nextLine();

        while (!player1Hand.isEmpty() && !player2Hand.isEmpty()) {
            System.out.println("Round " + round + ":");

            PlayingCard player1Card = player1Hand.remove(0);
            PlayingCard player2Card = player2Hand.remove(0);

            System.out.println(player1Name + " draws: " + player1Card);
            System.out.println(player2Name + " draws: " + player2Card);

            int result = compareCards(player1Card, player2Card);

            if (result > 0) {
                player1Wins++;
                System.out.println(player1Name + " wins this round!");
            } else if (result < 0) {
                player2Wins++;
                System.out.println(player2Name + " wins this round!");
            } else { // War scenario
                System.out.println("War!");

                // Draw three additional cards each
                List<PlayingCard> player1WarCards = new ArrayList<>();
                List<PlayingCard> player2WarCards = new ArrayList<>();
                for (int i = 0; i < 3 && !player1Hand.isEmpty() && !player2Hand.isEmpty(); i++) {
                    player1WarCards.add(player1Hand.remove(0));
                    player2WarCards.add(player2Hand.remove(0));
                }

                // Draw the face-up card
                PlayingCard player1WarCard = player1Hand.remove(0);
                PlayingCard player2WarCard = player2Hand.remove(0);

                System.out.println(player1Name + "'s face-up card: " + player1WarCard);
                System.out.println(player2Name + "'s face-up card: " + player2WarCard);

                // Compare face-up cards
                int warResult = compareCards(player1WarCard, player2WarCard);

                if (warResult > 0) {
                    player1Wins += (player1WarCards.size() + player2WarCards.size() + 1);
                    System.out.println(player1Name + " wins the war!");
                } else if (warResult < 0) {
                    player2Wins += (player1WarCards.size() + player2WarCards.size() + 1);
                    System.out.println(player2Name + " wins the war!");
                } else {
                    System.out.println("It's a tie again! Another war!");
                }
            }

            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            round++;
        }

        System.out.println("Game over!");
        System.out.println(player1Name + " wins: " + player1Wins + " rounds");
        System.out.println(player2Name + " wins: " + player2Wins + " rounds");

        if (player1Wins > player2Wins) {
            System.out.println(player1Name + " wins the game!");
        } else if (player2Wins > player1Wins) {
            System.out.println(player2Name + " wins the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static List<PlayingCard> generateDeck() {
        List<PlayingCard> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                PlayingCard card = new PlayingCard(suit, rank);
                deck.add(card);
            }
        }
        return deck;
    }

    public static int compareCards(PlayingCard card1, PlayingCard card2) {
        int rank1 = card1.getRank().getValue();
        int rank2 = card2.getRank().getValue();
        return Integer.compare(rank1, rank2);
    }
}








