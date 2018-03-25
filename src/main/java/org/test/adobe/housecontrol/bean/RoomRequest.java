
package org.test.adobe.housecontrol.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "light",
     "curtain",
    "temperature"
})
@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class RoomRequest implements Serializable
{
    @JsonProperty("light")
    public boolean light;
    @JsonProperty("curtain")
    public boolean curtain;
    @JsonProperty("temperature")
    public int temperature;

    private final static long serialVersionUID = -8618158330989202339L;

}
