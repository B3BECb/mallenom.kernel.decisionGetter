package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Plate {

    @JsonProperty("number")
    public String Number;

    @JsonProperty("confidence")
    public double Confidence;

    @JsonProperty("stencil")
    public Stencil Stencil;

    @JsonProperty("bounds")
    public List<Point> Bounds;

    @JsonProperty("symbols")
    public List<Symbol> Symbols;
}