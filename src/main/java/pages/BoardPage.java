package pages;

import io.restassured.response.Response;

public class BoardPage extends BasePage {
    private String boardId;
    private String listId;

    public void createBoard(String name) {
        String endpoint = "/boards/";
        String params = "?name=" + name + "&key=" + key + "&token=" + token;

        Response res = post(endpoint, params);
        boardId = res.jsonPath().getString("id");
    }

    public String createList(String listName) {
        String endpoint = "/boards/" + boardId + "/lists";
        String params = "?name=" + listName + "&key=" + key + "&token=" + token;

        Response res = post(endpoint, params);
        listId = res.jsonPath().getString("id");
        return listId;
    }

    public void deleteBoard() {
        String endpoint = "/boards/" + boardId;
        String params = "?key=" + key + "&token=" + token;
        delete(endpoint, params);
    }

    public String getBoardId() {
        return boardId;
    }

    public String getListId() {
        return listId;
    }
}
