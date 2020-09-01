import api.builders.ApiBuilder;
import beans.Board;
import beans.List;
import com.google.gson.Gson;
import io.restassured.http.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testData.BoardConstants;
import testData.ListConstants;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCommons {

    Board testBoard;
    Gson gson;
    String boardId;
    List testList;

    private String boardSuffix = "/1/boards";
    private String listSuffix = "1/lists";

    @BeforeClass
    public void createTestBoard() {
        String body = new ApiBuilder()
                .authorizeWithTokenAndKey()
                .setQueryParam("name", BoardConstants.NAME.value)
                .build(Method.POST, boardSuffix)
                .getBody().prettyPrint();
        gson = new Gson();
        testBoard = gson.fromJson(body, Board.class);
        assertThat(testBoard).isNotNull();
        boardId = testBoard.getId();
    }

    @BeforeClass
    public void createTestList() {
        String body = new ApiBuilder()
                .authorizeWithTokenAndKey()
                .setName(ListConstants.NAME.value)
                .setParentBoard(boardId)
                .build(Method.POST, listSuffix)
                .getBody().prettyPrint();
        testList = gson.fromJson(body, List.class);
    }


    @AfterClass(alwaysRun = true)
    public void deleteBoard() {
        String uriEnding = boardSuffix + "/" + boardId;
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .build(Method.DELETE, uriEnding)
                .prettyPrint();
    }
}
