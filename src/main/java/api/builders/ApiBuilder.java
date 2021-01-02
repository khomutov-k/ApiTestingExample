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
public class ApiBuilder implements IApiBuilder{
    protected Map<String,String> params = new HashMap<String, String>();
    private String baseUrl = "https://api.trello.com/";
    private Method requestMethod = Method.GET;

    public ApiBuilder authorizeWithTokenAndKey() {
       //Add here your creds
        params.put("key","");
       params.put("token","");
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

    public ApiBuilder setQuery(Map<String,String> queryValues) {
        params.putAll(queryValues);
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

    public ApiBuilder build() {
        authorizeWithTokenAndKey();
        return this;
    }

    public ApiBuilder build(Method method) {
        authorizeWithTokenAndKey();
        requestMethod = method;
        return this;
    }
    public Response sendGetRequest(String uriEnding) {
        return RestAssured.given()
                .queryParams(params)
                .baseUri(baseUrl)
                .log().all()
                .contentType(ContentType.JSON)
                .request(requestMethod, uriEnding)
                .prettyPeek();
    }

    public Response sendRequest(String uriEnding) {
        return RestAssured.given()
                .queryParams(params)
                .baseUri(baseUrl)
                .log().all()
                .contentType(ContentType.JSON)
                .request(requestMethod, uriEnding)
                .prettyPeek();
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectResponseTime(Matchers.lessThan(3000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

}
