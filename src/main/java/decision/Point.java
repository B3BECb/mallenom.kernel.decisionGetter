package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Point {

    @JsonProperty("x")
    public int X;

    @JsonProperty("y")
    public int Y;
}