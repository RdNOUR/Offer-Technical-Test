package com.offertechnicaltest.controller;

import com.offertechnicaltest.domain.User;
import com.offertechnicaltest.exception.ApplicationRequestException;
import com.offertechnicaltest.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Operation(summary = "This is to store the users into the data base...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user is stored in the data base...", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "The user informations are not valid...", content = {@Content})
    })
    @PostMapping(path = "api/registerUser", consumes = "application/json")
    public String registerUser (@RequestBody User user){
        if(user.getCountryOfResidence().equals("France") && user.getBirthdate().isBefore(LocalDate.parse("2003-12-31"))){
            userServiceImpl.registerUser(user);
            return ("Valid Input, the user is injected in the dataBase....");
        }else{
            throw new ApplicationRequestException("Invalid Input, the user must be an adult And live in france....");
        }
    }

    @Operation(summary = "This is to fetch all the users in the data base...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Display of all the users in the data base...", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "The service is not available...", content = {@Content})
    })
    @RequestMapping(path = "api/users")
    public List<User> getUsers(){
        return userServiceImpl.getUsers();
    }

}