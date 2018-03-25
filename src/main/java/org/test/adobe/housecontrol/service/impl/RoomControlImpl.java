package org.test.adobe.housecontrol.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.adobe.housecontrol.bean.Room;
import org.test.adobe.housecontrol.bean.RoomRequest;
import org.test.adobe.housecontrol.bean.RoomResonse;
import org.test.adobe.housecontrol.bean.Rooms;
import org.test.adobe.housecontrol.exception.APIException;
import org.test.adobe.housecontrol.service.RoomControl;
import org.test.adobe.housecontrol.service.RoomModelService;

@Service("roomcontrolservice")
@Slf4j
public class RoomControlImpl implements RoomControl {

    @Autowired
    RoomModelService roomModelService;

    @Override
    public RoomResonse updateRoom(String roomId ,RoomRequest roomRequest) throws APIException {
        return roomModelService.saveRoom(roomId , roomRequest);

    }

    @Override
    public Rooms getAllRooms()throws APIException {
        return roomModelService.findAllRooms();
    }

    @Override
    public Room getRoom(String roomId) throws APIException {
        return roomModelService.findRoomById(roomId);
    }

    @Override
    public boolean deleteRoom(String roomId) throws APIException{
        return roomModelService.deleteRoom(roomId);
    }
}
