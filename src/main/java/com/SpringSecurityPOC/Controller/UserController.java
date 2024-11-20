package com.SpringSecurityPOC.Controller;

import com.SpringSecurityPOC.Entity.ApiResponseModel;
import com.SpringSecurityPOC.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
     public ApiResponseModel validateUser(@RequestParam("userId") String userId,@RequestParam("password") String password)
     {
         ApiResponseModel apiResponseModel=userService.validateUser(userId,password);
         return apiResponseModel;
     }

     @GetMapping("/validate")
     public String validateToken(@RequestParam("token") String token,@RequestParam("userId") String userId)
     {
         System.out.println(token);
         System.out.println(userId);
         boolean status=userService.validateToken(token,userId);
         if(status)
         {
             return  "User is valid";
         }
         else
         {
             return "Invalid user or token expired";
         }

     }

}
