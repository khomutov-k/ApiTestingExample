package api.api;

import api.builders.ApiBuilder;
import beans.Board;
import beans.BoardSimplified;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class BoardAPI {

    public String boardUri = "1/boards";

    public List<BoardSimplified> getBoards() {
        String uriEnding = "1/members/me/boards";
        final Response response = new ApiBuilder()
                .sendGetRequest(uriEnding);
        String body = response.body().asString();
        Gson gson = new Gson();
        return gson.fromJson(body, new TypeToken<List<BoardSimplified>>() {
        }.getType());
    }

    public Board createNewBoard(String name) {
        String uriEnding = boardUri;
        String body = new ApiBuilder()
                .setName(name)
                .build(Method.POST)
                .sendRequest(uriEnding)
                .getBody().asString();
        Gson gson = new Gson();
        return gson.fromJson(body, Board.class);
    }

    public Board getBoardById(String id) {
        String uriEnding = boardUri + "/" + id;
        final Response response = new ApiBuilder()
                .build()
                .sendGetRequest(uriEnding);
        String body = response.getBody().asString();
        Gson gson = new Gson();
        Board board = gson.fromJson(body, Board.class);
        if (!board.getId().equals(id)) {
            //Throw exception
        }
        return board;
    }

    public Response getBoardWithLists(String boardId) {
        String uriEnding = boardUri + "/" + boardId;
        return new ApiBuilder()
                .getListBuilder()
                .buildQueryAndReturn()
                .build()
                .sendGetRequest(uriEnding);
    }

    public Response getBoard(String boardId, String uriQuery) {
        String uriEnding = boardUri + "/" + boardId + uriQuery;
        return new ApiBuilder()
                .build()
                .sendGetRequest(uriEnding);
    }

    public Response getBoardWithCards(String boardId) {
        String uriEnding = boardUri + "/" + boardId;
        return new ApiBuilder()
                .getCardBuilder()
                .buildQueryAndReturn()
                .build()
                .sendGetRequest(uriEnding);
    }

    public Response getField(String boardId, String field) {
        String uriEnding = boardUri + "/" + boardId + "/" + field;
        return new ApiBuilder()
                .build()
                .sendGetRequest(uriEnding);
    }

    public Response updateBoard(String boardId, Map<String, String> updatedValues) {
        String uriEnding = boardUri + "/" + boardId;
        return new ApiBuilder()
                .setQuery(updatedValues)
                .build(Method.PUT)
                .sendRequest(uriEnding);
    }

    public void deleteBoardById(String id) {
        String uriEnding = boardUri + "/" + id;
        new ApiBuilder()
                .build(Method.DELETE)
                .sendRequest(uriEnding);
    }
}
