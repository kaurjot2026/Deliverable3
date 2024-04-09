/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author HP
 */


/**
 * Represents a playing card in a standard deck.
 */
public class PlayingCard extends Card {

    public PlayingCard(Suit suit, Rank rank) {
        super(suit, rank);
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }
}

