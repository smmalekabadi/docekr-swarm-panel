package com.ie.docker_swarm.controller;

import com.github.dockerjava.api.model.Swarm;
import com.github.dockerjava.api.model.SwarmSpec;
import com.ie.docker_swarm.business.core.SwarmHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ie/nodes")
public class NodeController {
    private SwarmHandler swarmHandler;

    public NodeController(SwarmHandler swarmHandler) {
        this.swarmHandler = swarmHandler;
    }

    @RequestMapping(value = "/" , method ={RequestMethod.OPTIONS, RequestMethod.GET})
    public ResponseMessage<java.util.List<com.github.dockerjava.api.model.SwarmNode>> getNode(){
        return new ResponseMessage<>(1,swarmHandler.getNodes());
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseMessage<Boolean> updateNode(@RequestParam long version){
        return new ResponseMessage<>(1,swarmHandler.updateNode(version));
    }

//    @RequestMapping(value = "/test")
//    public ResponseMessage<Swarm> test(){
//        return new ResponseMessage<>(1,swarmHandler.getClusters());
//    }
}
