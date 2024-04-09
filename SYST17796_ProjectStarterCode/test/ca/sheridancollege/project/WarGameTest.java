/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class WarGameTest {
    
    public WarGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class WarGame.
     */
//    @Test
    //public void testWarGame() {
    //    // Simulate user input for player names
    //    String input = "Player 1\nPlayer 2\n";
    //    InputStream in = new ByteArrayInputStream(input.getBytes());
    //    System.setIn(in);
    //
    //    // Test the main method of WarGame class
    //    WarGame.main(null);
    //}

    @Test
    @SuppressWarnings("ThrowableResultIgnored")
    public void testCompareCards() {
        // Good Test Case: Card1 has higher rank than Card2
        PlayingCard card1 = new PlayingCard(Suit.HEARTS, Rank.ACE);
        PlayingCard card2 = new PlayingCard(Suit.CLUBS, Rank.KING);
        assertTrue(WarGame.compareCards(card1, card2) > 0);

        // Bad Test Case: Comparing invalid cards (null values)
        assertThrows(NullPointerException.class, () -> WarGame.compareCards(null, null));

        // Boundary Test Case: Comparing lowest and highest rank cards
        PlayingCard lowestRankCard = new PlayingCard(Suit.HEARTS, Rank.TWO);
        PlayingCard highestRankCard = new PlayingCard(Suit.SPADES, Rank.ACE);
        assertTrue(WarGame.compareCards(lowestRankCard, highestRankCard) < 0);
    }
    
    @Test
    public void testGenerateDeck() {
        // Good Test Case: Ensuring the generated deck has the correct size
        assertEquals(52, WarGame.generateDeck().size());

        // Bad Test Case: Ensuring the generated deck is not null
        assertNotNull(WarGame.generateDeck());

        // Boundary Test Case: Testing an empty deck
        WarGame.generateDeck().clear();
        assertEquals(52, WarGame.generateDeck().size());
    }
    
    @Test
    @SuppressWarnings("ThrowableResultIgnored")
    public void testWarScenario() {
        // Good Test Case: Cards with the same rank result in a war scenario
        PlayingCard card1 = new PlayingCard(Suit.HEARTS, Rank.TEN);
        PlayingCard card2 = new PlayingCard(Suit.DIAMONDS, Rank.TEN);
        assertEquals(0, WarGame.compareCards(card1, card2));

        // Bad Test Case: Comparing null cards (invalid scenario)
        assertThrows(NullPointerException.class, () -> WarGame.compareCards(null, null));

        // Boundary Test Case: Comparing cards with the lowest and highest ranks
        PlayingCard lowestRankCard = new PlayingCard(Suit.HEARTS, Rank.TWO);
        PlayingCard highestRankCard = new PlayingCard(Suit.SPADES, Rank.ACE);
        assertEquals(-1, WarGame.compareCards(lowestRankCard, highestRankCard));
    }
    
    
}
