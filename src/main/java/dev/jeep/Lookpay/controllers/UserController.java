package dev.jeep.Lookpay.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeep.Lookpay.dtos.ResetPasswordDTO;
import dev.jeep.Lookpay.dtos.ResetRequestPasswordDTO;
import dev.jeep.Lookpay.dtos.UserRegisterDTO;
import dev.jeep.Lookpay.dtos.UserUpdateDTO;
import dev.jeep.Lookpay.services.UserService;

@RestController
@RequestMapping("/user") // http://localhost:8080/user
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<LinkedHashMap<String, Object>> registerUser(@RequestBody UserRegisterDTO user) {
        return userService.register(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> ModifyUser(@PathVariable("id") Long id,
            @RequestBody UserUpdateDTO user) {
        return userService.update(id, user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/resetpassword/request")
    public ResponseEntity<LinkedHashMap<String, Object>> resetRequestPassword(
            @RequestBody ResetRequestPasswordDTO resetPasswordDTO) {
        return userService.resetRequestPassword(resetPasswordDTO);
    }

    @PutMapping(value = "/resetpassword/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> resetPassword(@PathVariable("id") Long id,
            @RequestBody ResetPasswordDTO newPassword) {
        return userService.resetPassword(id, newPassword);
    }
}
