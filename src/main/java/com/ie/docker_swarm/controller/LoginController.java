package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.business.core.RegisterHandler;
import com.ie.docker_swarm.business.data.Session;
import com.ie.docker_swarm.business.data.User;
import com.ie.docker_swarm.business.data.UserModel;
import com.ie.docker_swarm.business.verification.Token;
import com.ie.docker_swarm.business.verification.TokenModel;
import com.ie.docker_swarm.utils.ResponseMessage;
import com.ie.docker_swarm.utils.TokenMessage;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*" , allowedHeaders = "*",allowCredentials = "false")
@RestController
@RequestMapping("/ie")
public class LoginController {
    private RegisterHandler registerHandler;
    public LoginController(RegisterHandler registerHandler) {
    this.registerHandler = registerHandler;
    }
    @RequestMapping(value = "/users", method = {RequestMethod.OPTIONS,RequestMethod.POST})
    public TokenMessage register(@RequestBody UserModel User) {
        return new TokenMessage<>(new Token("thisMor"+Math.random()+"KiaSession"));

//        return registerHandler.obtainAccessToken(username, password);
    }
    @RequestMapping(value = "/user", method = {RequestMethod.OPTIONS,RequestMethod.GET})
    public TokenMessage log() {
        return new TokenMessage<>(new User("kia","https://gravatar.com/avatar/c47b3ea814648f16b6d5e4cc38452890?s=400&d=robohash&r=g"));

//        return registerHandler.obtainAccessToken(username, password);
    }


    @RequestMapping(value = "/sessions", method = {RequestMethod.OPTIONS,RequestMethod.POST })
    public TokenMessage login(@RequestBody Session session) {
        return new TokenMessage<>(new Token("thisMor"+Math.random()+"KiaSession"));
//        return registerHandler.obtainAccessToken(username, password);
    }
    @RequestMapping(value = "/sessions", method = RequestMethod.DELETE)
    public TokenMessage logout(@RequestBody Session session) {
        return new TokenMessage<>(new Token("thisMor"+Math.random()+"KiaSession"));


//        return registerHandler.obtainAccessToken(username, password);
    }

}
