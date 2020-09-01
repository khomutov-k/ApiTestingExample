package api.builders;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

//Builder pattern
public class ApiBuilder {
    protected Map<String,String> params = new HashMap<String, String>();
    private String baseUrl = "https://api.trello.com/";
    public ApiBuilder authorizeWithTokenAndKey() {
        params.put("key","80bd156d3b735dd62ae302a80a525105");
        params.put("token","82f3f75ea1fc434730c2b2f44607d41b6ea63ebd2a570c56b63dae7dac182576");
        return this;
    }

    public QueryParamApiBuilder getListBuilder() {
        return new QueryParamApiBuilder("list",this);
    }

    public QueryParamApiBuilder getCardBuilder() {
        return new QueryParamApiBuilder("card",this);
    }

    public ApiBuilder setFields(String ...fields) {
        String value = "";
        for (String field : fields) {
            value = value + field + ",";
        }
        params.put("fields", value.substring(0,value.length()-1));
        return this;
    }


    public ApiBuilder setQueryParam(String key,String value) {
        params.put(key,value);
        return this;
    }

    public ApiBuilder setQuery(Map<String,String> cardsRelatedMap) {
        params.putAll(cardsRelatedMap);
        return this;
    }

    public ApiBuilder setName(String value) {
        params.put("name",value);
        return this;
    }

    public ApiBuilder setParentBoard(String boardId) {
        params.put("idBoard",boardId);
        return this;
    }

    public Response build(Method method, String uriEnding) {
        final Response response = RestAssured.given()
                .queryParams(params)
                .baseUri(baseUrl)
                .log().all()
                .contentType(ContentType.JSON)
                .request(method, uriEnding);
        response.then().spec(successResponse());
        return response;
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectResponseTime(Matchers.lessThan(3000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

}
