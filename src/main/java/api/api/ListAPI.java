package api.api;

import api.builders.ApiBuilder;
import beans.List;
import com.google.gson.Gson;
import io.restassured.http.Method;
import io.restassured.response.Response;
import testData.ListConstants;

import java.util.Map;

public class ListAPI {

    String listUri = "1/lists";
    Gson gson = new Gson();

    public List createList(String boardId) {
        String body = new ApiBuilder()
                .authorizeWithTokenAndKey()
                .setName(ListConstants.NAME.value)
                .setParentBoard(boardId)
                .build(Method.POST)
                .sendRequest(listUri)
                .getBody().asString();
        return gson.fromJson(body, List.class);
    }
    public List getListDefault(String listId) {
        String uriEnding = listUri + "/" + listId;
        String body = new ApiBuilder()
                .build()
                .sendGetRequest(uriEnding)
                .getBody().prettyPrint();
        return gson.fromJson(body,List.class);
    }

    public List updateList(String listId, Map<String,String> updatedFields) {
        String uriEnding = listUri + "/" + listId;
        String body = new ApiBuilder()
                .setQuery(updatedFields)
                .build(Method.PUT)
                .sendRequest(uriEnding)
                .getBody().asString();
        return gson.fromJson(body,List.class);
    }

    public Response createCard(String listId) {
        return new ApiBuilder()
                .setQueryParam("idList",listId)
                .build(Method.POST)
                .sendRequest("1/cards");

    }

    public Response getCards(String listId) {
        String uriEnding = listUri + "/" + listId + "/cards";
        return new ApiBuilder()
                .build()
                .sendGetRequest(uriEnding);
    }
}
