package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movement {

    @JsonProperty("angle")
    public int Angle;

    @JsonProperty("direction")
    public int Direction;

    @JsonProperty("passage")
    public int Passage;

    @JsonProperty("name")
    public String Name;
}
