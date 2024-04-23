package com.texas.ecs.Ecommerce.controller;

import com.texas.ecs.Ecommerce.dto.UserDto;
import com.texas.ecs.Ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser( @RequestBody UserDto userDto){
        Integer id = userService.save(userDto);
        return ResponseEntity.ok(Map.of("message","User Saved Successfully.........."));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") Integer id){
        UserDto data = userService.getById(id);
        return ResponseEntity.ok(
                Map.of("message","User Fetched Successfully......","data",data)
        );
    }

    @GetMapping("/list")
    public ResponseEntity fetchAllUsers(){
        List<UserDto> data = userService.getAll();
        return ResponseEntity.ok(
                Map.of("message","User List Fetched Successfully........","data",data)
        );
    }
}