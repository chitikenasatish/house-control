package org.test.adobe.housecontrol.service;

import org.test.adobe.housecontrol.bean.Room;
import org.test.adobe.housecontrol.bean.RoomRequest;
import org.test.adobe.housecontrol.bean.RoomResonse;
import org.test.adobe.housecontrol.bean.Rooms;
import org.test.adobe.housecontrol.exception.APIException;

public interface RoomControl {

    public RoomResonse updateRoom(String roomId, RoomRequest roomRequest)throws APIException;

    public Rooms getAllRooms()throws APIException;

    public Room getRoom(String roomId)throws APIException;

    public boolean deleteRoom(String roomId)throws APIException;

}
