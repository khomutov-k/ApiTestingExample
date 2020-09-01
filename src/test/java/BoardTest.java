import api.builders.ApiBuilder;
import beans.Board;
import io.restassured.http.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.BoardConstants;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest extends TestCommons {

    String objectSuffix = "/1/boards";

    @Test
    public void getBoardDefault() {
        String uriEnding = objectSuffix + "/" + boardId;
        String body = new ApiBuilder()
                .authorizeWithTokenAndKey()
                .build(Method.GET, uriEnding)
                .getBody().prettyPrint();
        Board board = gson.fromJson(body, Board.class);
        assertThat(board.getName()).isEqualTo(testBoard.getName());
    }

    @Test
    public void getBoardWithLists() {
        String uriEnding = objectSuffix + "/" + boardId;
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .getListBuilder()
                .buildQueryAndReturn()
                .build(Method.GET, uriEnding)
                .getBody().prettyPrint();
    }

    @Test
    public void getBoardWithCards() {
        String uriEnding = objectSuffix + "/" + boardId;
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .getCardBuilder()
                .buildQueryAndReturn()
                .build(Method.GET, uriEnding)
                .getBody().prettyPrint();
    }

    @Test
    public void updateBoard() {
        String uriEnding = objectSuffix + "/" + boardId;
        String body = new ApiBuilder()
                .authorizeWithTokenAndKey()
                .setQueryParam("desc", BoardConstants.DESCRIPTION.value)
                .build(Method.PUT, uriEnding)
                .getBody().asString();
        testBoard = gson.fromJson(body, Board.class);
        assertThat(testBoard.getDesc()).isEqualTo(BoardConstants.DESCRIPTION.value);
    }

    @Test(dataProvider = "fieldsProvider")
    public void getField(String field) {
        String uriEnding = objectSuffix + "/" + boardId + "/" + field;
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .build(Method.GET, uriEnding)
                .prettyPrint();
    }

    @Test
    public void getMemberships() {
        String uriEnding = objectSuffix + "/" + boardId + "/memberships";
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .setQueryParam("members", "all")
                .build(Method.GET, uriEnding)
                .prettyPrint();
    }

    @Test
    public void getCards() {
        String uriEnding = objectSuffix + "/" + boardId + "/cards";
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .build(Method.GET, uriEnding)
                .prettyPrint();
    }

    @Test
    public void getLists() {
        String uriEnding = objectSuffix + "/" + boardId + "/lists";
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .build(Method.GET, uriEnding)
                .prettyPrint();
    }

    @DataProvider(name = "fieldsProvider")
    public Object[] fieldsProvider() {
        return new Object[]{"closed", "dateLastActivity", "dateLastView",
                "desc", "descData", "idOrganization", "invitations",
                "invited", "labelNames", "memberships", "name", "pinned",
                "powerUps", "prefs", "shortLink", "shortUrl", "starred", "subscribed", "url"};
    }
}

