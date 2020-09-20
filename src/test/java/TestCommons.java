import api.api.BoardAPI;
import api.api.ListAPI;
import beans.Board;
import beans.List;
import com.google.gson.Gson;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testData.BoardConstants;

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
        testBoard = new BoardAPI().createNewBoard(BoardConstants.NAME.value);
        gson = new Gson();
        assertThat(testBoard).isNotNull();
        boardId = testBoard.getId();
    }

    @BeforeClass
    public void createTestList() {
        testList = new ListAPI().createList(boardId);
    }


    @AfterClass(alwaysRun = true)
    public void deleteBoard() {
        new BoardAPI().deleteBoardById(boardId);
    }
}
