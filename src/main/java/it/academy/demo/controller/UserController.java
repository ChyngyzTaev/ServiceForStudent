package it.academy.demo.controller;

import it.academy.demo.model.request.AuthenticationRequest;
import it.academy.demo.model.response.AuthenticationResponse;
import it.academy.demo.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();

        if (username == null || username.isEmpty())
            return getErrorAuthorizationMessage("Заполните поле логин");

        if (password == null || password.isEmpty())
            return getErrorAuthorizationMessage("Заполните поле пароль");

        if (!username.equals("student") || !password.equals("student"))
            getErrorAuthorizationMessage("Неверный логин или пароль");
        else {
            getErrorAuthorizationMessage("Неверный логин или пароль");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    private ResponseEntity<?> getErrorAuthorizationMessage(String message) {
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }
}
