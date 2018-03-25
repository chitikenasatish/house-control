package org.test.adobe.housecontrol.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.test.adobe.housecontrol.bean.Room;
import org.test.adobe.housecontrol.bean.RoomRequest;
import org.test.adobe.housecontrol.bean.RoomResonse;
import org.test.adobe.housecontrol.bean.Rooms;
import org.test.adobe.housecontrol.exception.APIException;
import org.test.adobe.housecontrol.service.RoomModelService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

@Service("roommodelservice")
@Slf4j
public class RoomModelServiceImpl implements RoomModelService {

    Map<String , Room > roomsMap ;
    Rooms rooms;


    @PostConstruct
    private void init(){
        InputStream inputStream =
                getClass().getClassLoader().getResourceAsStream("home.json");
        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            rooms = objectMapper.readValue(reader, Rooms.class);
            // Concurrent Map to handle multiple requests
            roomsMap = rooms.rooms.stream().collect(
                    Collectors.toConcurrentMap(room -> room.getId(),room ->room ));
     } catch (IOException e) {
           log.error("Not able to fetch the Room details");
        }
    }

    @Override
    public Room findRoomById(String roomId)throws APIException {
        return roomsMap.get(roomId);
    }

    @Override
    public Room findRooms(String searchQuery) throws APIException{
        return null;
    }

    @Override
    public Rooms findAllRooms()throws APIException {
        Rooms rooms = new Rooms();
        rooms.setRooms(roomsMap.values().stream()
                .collect(Collectors.toList()));
        return rooms;
    }

    @Override
    public RoomResonse saveRoom(String roomId , RoomRequest roomRequest) throws APIException{
        Room room1 = roomsMap.get(roomId);
        String color;
        RoomResonse resonse = new RoomResonse();
        if(roomRequest.getTemperature() > 0 ){
            room1.setTemperature(roomRequest.getTemperature());
            resonse.setColor(roomRequest.getTemperature());
        }
        else {
            room1.setLight(roomRequest.isLight());
            room1.setCurtain(roomRequest.isCurtain());
            resonse.setOpacity(roomRequest.isLight() == true ? MyOptions.LIGHT_ON.getValue() : MyOptions.LIGHT_OFF.getValue());
            if (roomRequest.isCurtain()) {
                resonse.setOpacity(MyOptions.CURTAIN_ON.value);
            }
        }
        return resonse;
    }

    @Override
    public boolean deleteRoom(String roomId) throws APIException {
        roomsMap.remove(roomId);
        return true;
    }

    @RequiredArgsConstructor
    private enum MyOptions {
        LIGHT_ON(1),
        LIGHT_OFF(0.5),
        CURTAIN_ON(0.3),
        CURTAIN_OFF(0);

            @Getter
            private final double value;
        }
}
