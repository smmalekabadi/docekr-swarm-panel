package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.business.core.ContainerHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ie/container")
public class ContainerController {
    private ContainerHandler containerHandler;

    public ContainerController(ContainerHandler containerHandler) {
        this.containerHandler = containerHandler;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseMessage getContainer(@RequestParam(required = false) String id) {
        if (id == null)
            return new ResponseMessage<>(1, containerHandler.getContainerList());
        else
            return new ResponseMessage<>(1,containerHandler.getTopContainer(id));
    }

    @RequestMapping(value = "/", method =RequestMethod.PUT)
    public ResponseMessage<String> addContainer(@RequestParam(required = false) String cmd,@RequestParam String name) {
        return new ResponseMessage<>(1,containerHandler.createContainer(name ,cmd));

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseMessage<Boolean> updateContainer(@RequestParam String id, @RequestParam int state) {
        return new ResponseMessage<>(1, containerHandler.setState(state, id));
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseMessage<Boolean> deleteContainer(@RequestParam String id) {
        return new ResponseMessage<>(1, containerHandler.deleteContainer(id));
    }


}
