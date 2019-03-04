package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Channel {

    @JsonProperty("id")
    public int Id;

    @JsonProperty("name")
    public String Name;
}
