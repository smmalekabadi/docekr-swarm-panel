package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ie/nodes")
public class NodeController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseMessage<?> getNode(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public ResponseMessage<?> addNode(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseMessage<?> updateNode(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.DELETE)
    public ResponseMessage<?> deleteNode(){
        return null;
    }
}
