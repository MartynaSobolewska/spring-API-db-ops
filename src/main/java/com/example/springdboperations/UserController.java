package com.example.springdboperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    // use UserService instance
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Object> store(@RequestBody User user){
        User createdUser = service.storeUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") int id){
        User user = service.getUser(id);
        if (user != null){
                return ResponseEntity.status(HttpStatus.OK).body(user);
        }else{
            Map<String, String> map = new HashMap<>();
            map.put("Error", "User with id " + id + " not found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") int id){
        User usr = service.deleteUser(id);
        Map<String, String> map = new HashMap<>();
        if (usr != null){
            map.put("Success", "User with id " + id + " deleted!");
            return ResponseEntity.status(HttpStatus.OK).body(map);
        }else{
            map.put("Error", "User with id " + id + " not found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getUsers(){
        List<User> list = service.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
