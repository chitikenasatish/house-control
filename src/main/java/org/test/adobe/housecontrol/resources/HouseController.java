package org.test.adobe.housecontrol.resources;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.adobe.housecontrol.bean.Room;
import org.test.adobe.housecontrol.bean.RoomRequest;
import org.test.adobe.housecontrol.bean.RoomResonse;
import org.test.adobe.housecontrol.bean.Rooms;
import org.test.adobe.housecontrol.exception.APIException;
import org.test.adobe.housecontrol.service.RoomControl;

@RestController
@RequestMapping(value="/v1")
@EnableAutoConfiguration
@Slf4j
public class HouseController {

    @Autowired
    RoomControl roomControl;

    @RequestMapping(value = "/rooms" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getRooms() throws APIException {
        return new ResponseEntity<Rooms>(roomControl.getAllRooms(), HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getRoomById(@PathVariable String id) throws APIException {
        return new ResponseEntity<Room>(roomControl.getRoom(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/{id}" , method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateRoom(@PathVariable String id,@RequestBody(required = false) RoomRequest roomRequest)throws APIException  {
         return new ResponseEntity<RoomResonse>(roomControl.updateRoom(id,roomRequest), HttpStatus.OK);
    }
    @RequestMapping(value = "/rooms/{id}" , method = RequestMethod.DELETE , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteByRoomId(@PathVariable String id) throws APIException {
        return new ResponseEntity<Boolean>(roomControl.deleteRoom(id), HttpStatus.OK);
    }
}
