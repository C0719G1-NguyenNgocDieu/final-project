package com.codegym.controller;


import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.service.RoleService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> listMember() {
        System.out.println("ok");
        List<User> footballPlayers = userService.findAll();
        if (footballPlayers.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(footballPlayers, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/api/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        System.out.println("ok");
        User user1 = new User();
        if (userService.findByName(user.getEmail()) == null) {
            user1.setEmail(user.getEmail());
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
            user1.setRole(user.getRole());
            userService.save(user1);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.FAILED_DEPENDENCY);
    }

    @ResponseBody
    @RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteMember(@PathVariable Integer id) {
        if (userService.findById(id) == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } else {
            User footballPlayer = userService.findById(id);
            userService.deleteById(id);
            return new ResponseEntity<User>(footballPlayer, HttpStatus.OK);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/api/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateMember(@PathVariable Integer id,
                                             @RequestBody User user) {
        User originUser = userService.findById(id);

        if (originUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        originUser.setEmail(user.getEmail());
        originUser.setPassword(passwordEncoder.encode(user.getPassword()));
        originUser.setRole(user.getRole());
        originUser.setFirstName(user.getFirstName());
        originUser.setLastName(user.getLastName());
        originUser.setAddress(user.getAddress());
        originUser.setPhone(user.getPhone());



        userService.save(originUser);
        return new ResponseEntity<User>(originUser, HttpStatus.OK);
    }


}
