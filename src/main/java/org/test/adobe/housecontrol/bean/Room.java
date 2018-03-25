
package org.test.adobe.housecontrol.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "id",
    "light",
    "temperature",
    "curtain"
})
@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Room implements Serializable
{

    @JsonProperty("name")
    public String name;
    @JsonProperty("id")
    public String id;
    @JsonProperty("light")
    public boolean light;
    @JsonProperty("temperature")
    public int temperature;
    @JsonProperty("curtain")
    public boolean curtain;
    private final static long serialVersionUID = -8618158330989202339L;

}
