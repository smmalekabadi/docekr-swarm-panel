package com.ie.docker_swarm.controller;

import com.github.dockerjava.api.model.SearchItem;
import com.ie.docker_swarm.business.core.ImageHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ie/images")
public class ImageController {
    private ImageHandler imageHandler;

    public ImageController(ImageHandler imageHandler) {
        this.imageHandler = imageHandler;
    }

    @RequestMapping(value = "/", method ={RequestMethod.OPTIONS, RequestMethod.GET})
    public ResponseMessage getImage(@RequestParam(required = false) String id) {
        if (id == null)
            return new ResponseMessage<>(1, imageHandler.imageList());
        else
            return new ResponseMessage<>(1,imageHandler.inspectImage(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseMessage<Boolean> addImage(@RequestParam String name) {
        return new ResponseMessage<>(1, imageHandler.pullImage(name));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseMessage<?> updateImage(@RequestParam String name) {
        return new ResponseMessage<>(1, imageHandler.pushImage(name));
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseMessage<Boolean> deleteImage(@RequestParam String id) {
        return new ResponseMessage<>(1, imageHandler.removeImage(id));
    }

    @RequestMapping(value = "/search", method = {RequestMethod.OPTIONS,RequestMethod.GET})
    public ResponseMessage<List<SearchItem>> search(@RequestParam String search) {
        return new ResponseMessage<>(1, imageHandler.searchIamges(search));
    }
}
