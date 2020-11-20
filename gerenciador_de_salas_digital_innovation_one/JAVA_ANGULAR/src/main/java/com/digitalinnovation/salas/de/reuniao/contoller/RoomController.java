package com.digitalinnovation.salas.de.reuniao.contoller;


import com.digitalinnovation.salas.de.reuniao.exceptions.ResourceNotFoundException;
import com.digitalinnovation.salas.de.reuniao.model.Room;
import com.digitalinnovation.salas.de.reuniao.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1")
public class RoomController {

   @Autowired
   private RoomRepository roomRepository;

   @GetMapping("/rooms")
   public List<Room> getAllRooms(){
      return roomRepository.findAll();
   }

   @GetMapping("/rooms/{id}")
   public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Long roomId) throws ResourceNotFoundException {

         Room rom = roomRepository.findById(roomId)
                 .orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));
         return ResponseEntity.ok().body(rom);
      }


      @PostMapping("/rooms")
      public Room  createRoom(@Valid @RequestBody Room room){
      return roomRepository.save(room);
      }


      @PutMapping("/room/{id}")
      public ResponseEntity<Room> updateRoom(@PathVariable (value = "id") Long roomId , @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException{

      Room room = roomRepository.findById(roomId)
              .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id::" + roomId));
          room.setName(roomDetails.getName());
          room.setData(roomDetails.getData());
          room.setStartHour(roomDetails.getStartHour());
          room.setEndHour(roomDetails.getEndHour());

          final Room updateRooms = roomRepository.save(room);

          return ResponseEntity.ok(updateRooms);

      }


      @DeleteMapping("/room/{id}")
      public Map<String,Boolean> deleteRoom(@PathVariable(value = "id") Long id ) throws ResourceNotFoundException{
      Room room =  roomRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id" + id));
      roomRepository.delete(room);
      Map<String , Boolean> stringBooleanMap = new HashMap<>();
      stringBooleanMap.put("delete" , Boolean.TRUE);
      return stringBooleanMap;
      }

}

