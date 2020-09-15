package com.web.curation.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.curation.dao.user.UserDao;
import com.web.curation.model.BasicResponse;
import com.web.curation.model.user.User;
import com.web.curation.service.JwtService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
        @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
        @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })

// @CrossOrigin(origins = { "https://i3a310.p.ssafy.io:80", "http://localhost:3000" })
@CrossOrigin(origins = { "*" })
@RestController
public class UserController {

    @Autowired
    UserDao userDao;
    
    @Autowired
	JwtService jwtService;

    @PostMapping("/account/login")
    @ApiOperation(value = "로그인")
    public Object login(@RequestBody User user, HttpServletResponse res) {
            Optional<User> userOpt = userDao.findByIdAndPassword(user.getId(), user.getPassword());
            BasicResponse result = new BasicResponse(); 
        if (userOpt.isPresent()) {
            result.status = true;
            result.object = userOpt.get();
            
            // 성공하면 토큰 생성
            String token = jwtService.create(user);
            res.setHeader("jwt-auth-token", token);
            
            return new ResponseEntity<> (result, HttpStatus.OK);
        } else {
            result.status = false;
            return new ResponseEntity<> (result, HttpStatus.NOT_FOUND);
        }
    }
}
