package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.business.core.ContainerHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/", method ={RequestMethod.OPTIONS ,RequestMethod.GET})
    public ResponseMessage getContainer(@RequestParam(required = false)  String id) {
        if (id == null)
            return new ResponseMessage<>(1, containerHandler.getContainerList());
        else
            return new ResponseMessage<>(1,containerHandler.getTopContainer(id));
    }

    @RequestMapping(value = "/", method ={RequestMethod.OPTIONS,RequestMethod.PUT})
    public ResponseMessage addContainer(@RequestParam(required = false) String name,@RequestParam(required = false)  String image) {
        String a = containerHandler.createContainer(name ,image);
        return new ResponseMessage<>(1,a!=null ? a : HttpStatus.UNPROCESSABLE_ENTITY );

    }

    @RequestMapping(value = "/", method = {RequestMethod.OPTIONS,RequestMethod.POST})
    public ResponseMessage updateContainer(@RequestParam String id, @RequestParam  int state) {
        boolean b = containerHandler.setState(state, id);
        return new ResponseMessage<>(1, b ? b : HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseMessage<Boolean> deleteContainer(@RequestParam  String id) {
        return new ResponseMessage<>(1, containerHandler.deleteContainer(id));
    }


}
