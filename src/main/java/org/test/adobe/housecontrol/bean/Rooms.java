
package org.test.adobe.housecontrol.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Rooms"
})
@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Rooms implements Serializable
{

    @JsonProperty("Rooms")
    public List<Room> rooms = null;
    private final static long serialVersionUID = 2450040450777975526L;

}
