package com.page.page.Controllers;

import com.page.page.Services.UserService;
import com.page.page.models.Loginusers;
import com.page.page.models.Registerusermanual;
import com.page.page.models.Userdetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page")
public class usercontroller {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Loginusers loginusers){
        ResponseEntity<String> status = userService.login(loginusers);
        if(status.getStatusCode().is2xxSuccessful()){
            httpSession.setAttribute("user",loginusers.getEmail());
        }
        return status;
    }

    @GetMapping("/home")
    public ResponseEntity<String> homepage(){
        if(httpSession.getAttribute("user") == null){
            return ResponseEntity.status(403).body("Login First");
        }
        else{
            return ResponseEntity.ok("WELCOME");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registeruser(@RequestBody Registerusermanual registerusermanual){
        return userService.register(registerusermanual);
//        return userService.registeruser(userdetails);
    }
}
