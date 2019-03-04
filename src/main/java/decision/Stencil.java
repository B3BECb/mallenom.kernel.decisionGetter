package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stencil {

    @JsonProperty("id")
    public String Id;

    @JsonProperty("country")
    public Country Country;
}

