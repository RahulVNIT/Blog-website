package dev.farhan.movieist.movies;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {

        if (service.findUserByUserName(user.getUserName()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        try {

            // Save the user to the database
            service.save(user);

            return ResponseEntity.ok("Signup successful");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Signup failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {


        if (service.findUserByUserName(user.getUserName()) != null) {
            return ResponseEntity.ok("login successfull");
        }
        try {
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }
}
