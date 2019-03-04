package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Timestamps {

    @JsonProperty("bestFrame")
    public Date BestFrame;

    @JsonProperty("firstFrame")
    public Date FirstFrame;

    @JsonProperty("lastFrame")
    public Date LastFrame;
}
