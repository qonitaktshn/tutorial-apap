package apap.tutorial.cineplux.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgePenjaga {
    @JsonProperty("name")
    private String nanmaPenjaga;

    @JsonProperty("age")
    private Integer umur;

    @JsonProperty("count")
    private Integer count;
}
