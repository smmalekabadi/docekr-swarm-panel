package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.business.core.RegisterHandler;
import com.ie.docker_swarm.business.verification.TokenModel;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ie/login")
public class LoginController {
    private RegisterHandler registerHandler;
    public LoginController(RegisterHandler registerHandler) {
    this.registerHandler = registerHandler;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String updateContainer(@RequestParam String username, @RequestParam String password) {
        return registerHandler.obtainAccessToken(username, password);
    }

}
