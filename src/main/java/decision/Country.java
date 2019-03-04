package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty("id")
    public String Id;

    @JsonProperty("iso31066_1_Alpha2")
    public String Iso31066_1_Alpha2;

    @JsonProperty("iso31066_1_Alpha3")
    public String Iso31066_1_Alpha3;

    @JsonProperty("iso31066_1_Numeric")
    public String Iso31066_1_Numeric;
}
