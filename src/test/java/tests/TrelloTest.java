package tests;

import org.junit.Test;
import pages.BoardPage;
import pages.CardPage;

public class TrelloTest {
    @Test
    public void trelloApiScenario() {
        BoardPage boardPage = new BoardPage();
        CardPage cardPage = new CardPage();

        boardPage.createBoard("TestBoard");

        String listId = boardPage.createList("ToDo");

        cardPage.createCard(listId, "Card One");
        cardPage.createCard(listId, "Card Two");

        cardPage.updateRandomCard();

       cardPage.deleteAllCards();

       boardPage.deleteBoard();
    }
}
