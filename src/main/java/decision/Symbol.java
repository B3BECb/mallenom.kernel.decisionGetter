package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Symbol {

    @JsonProperty("char")
    public String Char;

    @JsonProperty("order")
    public Integer Order;

    @JsonProperty("confidence")
    public double Confidence;

    @JsonProperty("bounds")
    public List<Point> Bounds;
}
