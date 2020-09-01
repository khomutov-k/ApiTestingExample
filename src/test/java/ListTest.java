import api.builders.ApiBuilder;
import beans.List;
import io.restassured.http.Method;
import org.testng.annotations.Test;
import testData.ListConstants;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest extends TestCommons{

    String objectSuffix = "1/lists";

    @Test
    public void getListDefault() {
        String uriEnding = objectSuffix + "/" + testList.getId();
        String body = new ApiBuilder()
                .authorizeWithTokenAndKey()
                .build(Method.GET, uriEnding)
                .getBody().prettyPrint();
        List listFromGet = gson.fromJson(body,List.class);
        assertThat(listFromGet).isEqualTo(testList);
    }

    @Test
    public void updateList() {
        String uriEnding = objectSuffix + "/" + testList.getId();
        String body = new ApiBuilder()
                .authorizeWithTokenAndKey()
                .setName(ListConstants.DESCRIPTION.value)
                .build(Method.PUT, uriEnding)
                .getBody().asString();
        testList = gson.fromJson(body,List.class);
        assertThat(testList.getName()).isEqualTo(ListConstants.DESCRIPTION.value);
    }

    @Test
    public void createCard() {
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .setQueryParam("idList",testList.getId())
                .build(Method.POST,"1/cards");
    }

    @Test
    public void getCards() {
        String uriEnding = objectSuffix + "/" + testList.getId() + "/cards";
        new ApiBuilder()
                .authorizeWithTokenAndKey()
                .build(Method.GET, uriEnding)
                .getBody().prettyPrint();
    }
}
