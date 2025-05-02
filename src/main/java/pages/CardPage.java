package pages;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardPage extends BasePage {
    private final List<String> cardIds = new ArrayList<>();

    public void createCard(String listId, String cardName) {
        String endpoint = "/cards";
        String params = "?idList=" + listId + "&name=" + cardName + "&key=" + key + "&token=" + token;
        Response res = post(endpoint, params);
        String cardId = res.jsonPath().getString("id");
        cardIds.add(cardId);
    }

    public void updateRandomCard() {
        if (cardIds.isEmpty()) return;
        String randomCardId = cardIds.get(new Random().nextInt(cardIds.size()));
        String endpoint = "/cards/" + randomCardId;
        String params = "?name=UpdatedCard&key=" + key + "&token=" + token;
        put(endpoint, params);
    }

    public void deleteAllCards() {
        for (String cardId : cardIds) {
            String endpoint = "/cards/" + cardId;
            String params = "?key=" + key + "&token=" + token;
            delete(endpoint, params);
        }
    }
}
