package com.shane.controller;

import com.shane.component.JwtUtil;
import com.shane.entity.User;
import com.shane.repository.UserRepository;
import com.shane.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserService userService;
    public UserController(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User newUser = userService.registerUser(user.getUsername(), user.getPassword(), "USER");

        return ResponseEntity.ok(newUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> dbUser = userService.findByUsername(user.getUsername());

        if (dbUser.isPresent() && passwordEncoder.matches(user.getPassword(), dbUser.get().getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

}
