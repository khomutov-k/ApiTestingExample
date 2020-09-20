package api.builders;

import java.util.Map;

public class QueryParamApiBuilder {

    protected Map<String,String> params;
    ApiBuilder parent;
    String suffix;

    public QueryParamApiBuilder(String suffix, ApiBuilder parent) {
        this.parent = parent;
        this.params = parent.params;
        this.suffix = suffix;
        params.put(suffix + "s", "all");
    }

    public QueryParamApiBuilder setParam(String scope) {
        params.put(suffix + "s", scope);
        return this;
    }

    public QueryParamApiBuilder setFields(String ...fields) {
        String value = "";
        for (String field : fields) {
            value = value + field + ",";
        }
        params.put(suffix + "_fields", value.substring(0,value.length()-1));
        return this;
    }

    public ApiBuilder buildQueryAndReturn() {
        return parent;
    }
}
