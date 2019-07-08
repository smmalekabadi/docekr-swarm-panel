package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.business.core.VolumeHandler;
import com.ie.docker_swarm.business.data.VolumeModel;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ie/volume")
public class VolumeController {
    private VolumeHandler volumeHandler;

    public VolumeController(VolumeHandler volumeHandler) {
        this.volumeHandler = volumeHandler;
    }

    @RequestMapping(value = "/", method = {RequestMethod.OPTIONS,RequestMethod.GET})
    public ResponseMessage getVolume(@RequestParam(required = false) String name) {
        if (name == null)
            return new ResponseMessage<>(1, volumeHandler.getVolumes());
        else
            return new ResponseMessage<>(1,volumeHandler.inspect(name));
    }

    @RequestMapping(value = "/", method = {RequestMethod.OPTIONS ,RequestMethod.PUT})
    public ResponseMessage addVolume(@RequestParam String name) {
        VolumeModel a = volumeHandler.create(name);
        return new ResponseMessage<>(1, a != null ? a: HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @RequestMapping(value = "/", method = {RequestMethod.OPTIONS,RequestMethod.DELETE})
    public ResponseMessage deleteVolume(@RequestParam String name) {
        return new ResponseMessage<>(1, volumeHandler.remove(name));
    }
}
