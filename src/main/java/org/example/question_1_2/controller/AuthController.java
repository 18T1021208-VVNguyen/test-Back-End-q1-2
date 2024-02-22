package org.example.question_1_2.controller;

import jakarta.validation.Valid;
import org.example.question_1_2.payload.request.SignupRequest;
import org.example.question_1_2.payload.response.MessageResponse;
import org.example.question_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if ( userService.existsByUserName(signUpRequest.getUsername()) ) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
