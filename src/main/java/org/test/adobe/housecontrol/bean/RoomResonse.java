package org.test.adobe.housecontrol.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "opacity",
        "color"

})
@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class RoomResonse {
    private double opacity;
    private long color;
}
