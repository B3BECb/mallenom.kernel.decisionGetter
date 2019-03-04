package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class DecisionObj {

    @JsonProperty("tokens")
    public List<String> Tokens;

    @JsonProperty("id")
    public int Id;

    @JsonProperty("channel")
    public Channel Channel;

    @JsonProperty("timestamps")
    public Timestamps Timestamps;

    @JsonProperty("plate")
    public Plate Plate;

    @JsonProperty("movement")
    public Movement Movement;

    @JsonProperty("additionalInfo")
    public AdditionalInfo AdditionalInfo;
}

