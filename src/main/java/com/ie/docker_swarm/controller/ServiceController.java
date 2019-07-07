package com.ie.docker_swarm.controller;

import com.github.dockerjava.api.model.ServiceSpec;
import com.ie.docker_swarm.business.core.ServiceHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ie/services")
public class ServiceController {
    private ServiceHandler serviceHandler;
    public ServiceController(ServiceHandler serviceHandler){


        this.serviceHandler = serviceHandler;
    }
    @RequestMapping(value = "/" , method ={RequestMethod.OPTIONS, RequestMethod.GET})
    public ResponseMessage getService(@RequestParam(required = false) String id){
        if (id == null) {
            return new ResponseMessage<>(1, serviceHandler.getServiceList());
        }else
            return new ResponseMessage<>(1,serviceHandler.inspect(id));
    }
    @RequestMapping(value = "/" , method = RequestMethod.PUT)
    public ResponseMessage<String> addService(@RequestBody ServiceSpec serviceSpec){
        return new ResponseMessage<>(1,serviceHandler.createService(serviceSpec));
    }
    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseMessage<Boolean> updateService(@RequestParam String id, @RequestBody ServiceSpec serviceSpec,@RequestParam Long version){
        return new ResponseMessage<>(1,serviceHandler.updateService(id,serviceSpec,version));
    }
    @RequestMapping(value = "/" , method = RequestMethod.DELETE)
    public ResponseMessage<Boolean> deleteService(@RequestParam String id){

        return new ResponseMessage<>(1,serviceHandler.deleteService(id));
    }

}
