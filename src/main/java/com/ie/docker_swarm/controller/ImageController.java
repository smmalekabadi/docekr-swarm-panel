package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ie/images")
public class ImageController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseMessage<?> getImage(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public ResponseMessage<?> addImage(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseMessage<?> updateImage(){
        return null;
    }
    @RequestMapping(value = "/" , method = RequestMethod.DELETE)
    public ResponseMessage<?> deleteImage(){
        return null;
    }

}
