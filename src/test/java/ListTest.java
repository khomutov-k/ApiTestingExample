import api.api.ListAPI;
import beans.List;
import org.testng.annotations.Test;
import testData.ListConstants;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.notNullValue;

public class ListTest extends TestCommons{

    String objectSuffix = "1/lists";
    ListAPI listAPI = new ListAPI();
    @Test
    public void getListDefault() {
        List listFromGet = new ListAPI().getListDefault(testList.getId());
        assertThat(listFromGet).isEqualTo(testList);
    }

    @Test
    public void updateList() {
        Map<String,String> updatedValues = new HashMap<String, String>();
        updatedValues.put("name", ListConstants.DESCRIPTION.value);
        testList = listAPI.updateList(testList.getId(),updatedValues);
        assertThat(testList.getName()).isEqualTo(ListConstants.DESCRIPTION.value);
    }

    @Test
    public void createCard() {
        listAPI.createCard(testList.getId())
                .then().body(notNullValue());
    }

    @Test
    public void getCards() {
        listAPI.getCards(testList.getId())
                .then().body("name",contains(""));
    }
}
