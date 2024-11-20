package com.SpringSecurityPOC.Service;

import com.SpringSecurityPOC.Entity.ApiResponseModel;
import com.SpringSecurityPOC.Entity.User;
import com.SpringSecurityPOC.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
     private JwtUtils jwtAutorization;

    @Autowired
    private UserRepository userRepo;

    public ApiResponseModel validateUser(String userId,String password)
    {
        Optional<User> opt=userRepo.findById(userId);
        if(opt.isPresent())
        {
            User user=opt.get();
            if(user.getPassword().equals(password))
            {
                String token=jwtAutorization.generateToken(user.getUserID());
                return new ApiResponseModel(user,token,"User valid");
            }
            return new ApiResponseModel(null,null,"Invalid Credential");
        }else {

            return new ApiResponseModel(null,null,"User not found");
        }
    }

    public  boolean validateToken(String token,String userId)
    {
        boolean status= jwtAutorization.validateToken(token,userId);
        return status;
    }

}
