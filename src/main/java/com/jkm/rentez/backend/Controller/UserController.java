package com.jkm.rentez.backend.controller;

import com.jkm.rentez.backend.entity.UserEntity;
import com.jkm.rentez.backend.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    @RestController
    @RequestMapping(path="/api/users")
    public class UserController {
    
        private UserService userService;
    
        public UserController(UserService userService) {
            this.userService=userService;
        }
    
        @GetMapping
        public List<UserEntity> getUsers() {
            return userService.getAllUsers();
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
            Optional<UserEntity> user = userService.getUserById(id);
            return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
    
        @PostMapping
        public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
            try {
                UserEntity newUser = userService.createUser(user);
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
            try {
                userService.deleteUser(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    