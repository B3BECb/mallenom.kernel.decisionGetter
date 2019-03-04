package decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdditionalInfo {

    @JsonProperty("framecount")
    public int Framecount;

    @JsonProperty("reason")
    public String Reason;

    @JsonProperty("isBlocked")
    public Boolean IsBlocked;
}