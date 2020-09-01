
package beans;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "label"
})
public class LabelNames {

    @JsonProperty("label")
    private LabelNames.Label label;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("label")
    public LabelNames.Label getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(LabelNames.Label label) {
        this.label = label;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LabelNames.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("label");
        sb.append('=');
        sb.append(((this.label == null)?"<null>":this.label));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LabelNames)) {
            return false;
        }
        LabelNames rhs = ((LabelNames) other);
        return this.label == rhs.label && (this.additionalProperties == rhs.additionalProperties || this.additionalProperties != null && this.additionalProperties.equals(rhs.additionalProperties));
    }

    public enum Label {

        GREEN("green"),
        YELLOW("yellow"),
        ORANGE("orange"),
        RED("red"),
        PURPLE("purple"),
        BLUE("blue"),
        SKY("sky"),
        LIME("lime"),
        PINK("pink"),
        BLACK("black");
        private final String value;
        private final static Map<String, LabelNames.Label> CONSTANTS = new HashMap<String, LabelNames.Label>();

        static {
            for (LabelNames.Label c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Label(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static LabelNames.Label fromValue(String value) {
            LabelNames.Label constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
