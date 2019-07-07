package com.ie.docker_swarm.controller;

import com.github.dockerjava.api.model.Swarm;
import com.github.dockerjava.api.model.SwarmSpec;
import com.ie.docker_swarm.business.core.SwarmHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ie/swarm")
public class SwarmController {
    private SwarmHandler swarmHandler;

    public SwarmController(SwarmHandler swarmHandler) {
        this.swarmHandler = swarmHandler;
    }
    @RequestMapping(value =  "/" , method = {RequestMethod.OPTIONS,RequestMethod.GET})
    public ResponseMessage<Swarm> get(){
        return new ResponseMessage<>(1,swarmHandler.getClusters());
    }
    @RequestMapping(value = "/init", method = {RequestMethod.OPTIONS,RequestMethod.POST})
    public ResponseMessage<Boolean> initSwarm(@RequestBody SwarmSpec swarmSpec){
        return new ResponseMessage<>(1,swarmHandler.init(swarmSpec));
    }
    @RequestMapping(value = "/join",method = {RequestMethod.OPTIONS,RequestMethod.GET})
    public ResponseMessage<Boolean> joinSwarm(){
        return new ResponseMessage<>(1,swarmHandler.join());
    }
    @RequestMapping(value = "/leave",method = {RequestMethod.OPTIONS,RequestMethod.GET})
    public ResponseMessage<Boolean> leaveSwarm(){
        return new ResponseMessage<>(1,swarmHandler.leave());
    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseMessage<Boolean> update(@RequestBody SwarmSpec swarmSpec,@RequestParam long version){
        return new ResponseMessage<>(1,swarmHandler.updateSwarm(swarmSpec,version));
    }

}
