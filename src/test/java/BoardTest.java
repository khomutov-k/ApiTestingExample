import api.api.BoardAPI;
import api.builders.ApiBuilder;
import beans.Board;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.BoardConstants;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class BoardTest extends TestCommons {

    public static final Matcher<String> NOT_STARTWITH_CANNOT_GET = not(startsWith("Cannot GET"));

    @Test
    public void getBoardDefault() {
        Board board = new BoardAPI().getBoardById(boardId);
        assertThat(board.getName()).isEqualTo(testBoard.getName());
    }

    @Test
    public void getBoardWithListsNotEmpty() {
        Response response = new BoardAPI().getBoardWithLists(boardId);
        response.prettyPrint();
        response.then()
                .spec(ApiBuilder.successResponse())
                .body("lists", not(empty()));

    }

    @Test
    public void getBoardWithCards() {
        new BoardAPI().getBoardWithCards(boardId)
                .then()
                .spec(ApiBuilder.successResponse())
                .body("cards", notNullValue());
    }

    @Test
    public void updateBoard() {
        Map<String, String> updatedValues = new HashMap<String, String>();
        updatedValues.put("desc", BoardConstants.DESCRIPTION.value);

        String body = new BoardAPI()
                .updateBoard(boardId, updatedValues)
                .asString();
        testBoard = gson.fromJson(body, Board.class);
        assertThat(testBoard.getDesc()).isEqualTo(BoardConstants.DESCRIPTION.value);
    }

    @Test
    public void getMemberships() {
        new BoardAPI().getBoard(boardId, "/memberships")
                .then().body(NOT_STARTWITH_CANNOT_GET);
    }

    @Test
    public void getCards() {
        new BoardAPI().getBoard(boardId, "/cards")
                .then().body(NOT_STARTWITH_CANNOT_GET);
    }

    @Test
    public void getLists() {
        new BoardAPI().getBoard(boardId, "/lists")
                .then().body(NOT_STARTWITH_CANNOT_GET);
    }

    //  Bug in Trello docs was found
    @Test(dataProvider = "fieldsProvider")
    public void getField(String field) {
        new BoardAPI().getField(boardId, field)
                .then().body(NOT_STARTWITH_CANNOT_GET);
    }

    @DataProvider(name = "fieldsProvider")
    public Object[] fieldsProvider() {
        return new Object[]{"closed", "dateLastActivity", "dateLastView",
                "desc", "descData", "idOrganization", "invitations",
                "invited", "labelNames", "memberships", "name", "pinned",
                "powerUps", "prefs", "shortLink", "shortUrl", "starred", "subscribed", "url"};
    }
}

