package com.page.page.Services;

import com.page.page.Repositories.Userrepo;
import com.page.page.models.Loginusers;
import com.page.page.models.Registerusermanual;
import com.page.page.models.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private Userrepo userrepo;
    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;

    public ResponseEntity<String> login(Loginusers loginusers){
        Optional<Userdetails> user = userrepo.findByemail(loginusers.getEmail());
        if(user.isEmpty()){
            return ResponseEntity.status(404).body("User Not Found");
        }
        else if(!PasswordEncoder.matches(loginusers.getPassword(), user.get().getPassword())){
            return ResponseEntity.status(401).body("Invalid Password");
        }
        else{
            return ResponseEntity.ok("Login Successful");

        }
    }

    public ResponseEntity<String> register(Registerusermanual registerusermanual){
        Optional<Userdetails> user = userrepo.findByemail(registerusermanual.getEmail());
        if (user.isPresent()){
            return ResponseEntity.status(400).body("Email Already Registered");
        }
        else if(!registerusermanual.getPassword().equals(registerusermanual.getConfirmedpassword())){
            return ResponseEntity.status(401).body("password Mismatching");
        }
        else{
            Userdetails saveuserdetails = new Userdetails();
            String Hashpassword = PasswordEncoder.encode(registerusermanual.getPassword());
            saveuserdetails.setEmail(registerusermanual.getEmail());
            saveuserdetails.setPassword(Hashpassword);
            userrepo.save(saveuserdetails);
            return ResponseEntity.ok("Registered Successfully");
        }
    }
}
