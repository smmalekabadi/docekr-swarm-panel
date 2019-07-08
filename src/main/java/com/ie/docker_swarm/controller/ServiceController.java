package com.ie.docker_swarm.controller;

import com.github.dockerjava.api.model.ServiceSpec;
import com.ie.docker_swarm.business.core.ServiceHandler;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
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
    public ResponseMessage addService(@RequestBody ServiceSpec serviceSpec){
        String a = serviceHandler.createService(serviceSpec);
        return new ResponseMessage<>(1,a!=null? a: HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseMessage updateService(@RequestParam String id, @RequestBody ServiceSpec serviceSpec,@RequestParam Long version){
        Boolean a = serviceHandler.updateService(id, serviceSpec, version);
        return new ResponseMessage<>(1,a?a :HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @RequestMapping(value = "/" , method = RequestMethod.DELETE)
    public ResponseMessage<Boolean> deleteService(@RequestParam String id){

        return new ResponseMessage<>(1,serviceHandler.deleteService(id));
    }

}
