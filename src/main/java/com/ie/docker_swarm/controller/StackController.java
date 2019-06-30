package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id/stack")
public class StackController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseMessage<?> getStack(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public ResponseMessage<?> addStack(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseMessage<?> updateStack(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.DELETE)
    public ResponseMessage<?> deleteStack(){
        return null;
    }
}
