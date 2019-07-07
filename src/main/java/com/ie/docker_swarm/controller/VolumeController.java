package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.business.core.VolumeHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ie/volume")
public class VolumeController {
    private VolumeHandler volumeHandler;

    public VolumeController(VolumeHandler volumeHandler) {
        this.volumeHandler = volumeHandler;
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseMessage getVolume(){
        return new ResponseMessage<>(1,volumeHandler.getVolumes());
    }
    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public ResponseMessage addVolume(@RequestParam String name){
        return new ResponseMessage<>(1,volumeHandler.create(name));
    }
    @RequestMapping(value = "/" , method = RequestMethod.DELETE)
    public ResponseMessage deleteVolume(@RequestParam String name){
        return new ResponseMessage<>(1, volumeHandler.remove(name));
    }
}
