package org.test.adobe.housecontrol.service;

import org.test.adobe.housecontrol.bean.Room;
import org.test.adobe.housecontrol.bean.RoomRequest;
import org.test.adobe.housecontrol.bean.RoomResonse;
import org.test.adobe.housecontrol.bean.Rooms;
import org.test.adobe.housecontrol.exception.APIException;

public interface RoomModelService {

    public Room findRoomById(String roomId) throws APIException;

    public Room findRooms(String searchQuery)throws APIException;

    public Rooms findAllRooms()throws APIException;

    public RoomResonse saveRoom(String roomId , RoomRequest roomRequest)throws APIException;

    public boolean deleteRoom(String roomId )throws APIException;
}
