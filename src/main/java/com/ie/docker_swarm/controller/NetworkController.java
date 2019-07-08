package com.ie.docker_swarm.controller;

import com.ie.docker_swarm.business.core.NetworkHandler;
import com.ie.docker_swarm.business.data.NetworkModel;
import com.ie.docker_swarm.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ie/network")
public class NetworkController {
    private NetworkHandler networkHandler;

    public NetworkController(NetworkHandler networkHandler) {
        this.networkHandler = networkHandler;
    }

    @RequestMapping(value = "/", method = {RequestMethod.OPTIONS, RequestMethod.GET})
    public ResponseMessage getNetwork() {
        return new ResponseMessage<>(1, networkHandler.getNetworks());
    }

    @RequestMapping(value = "/", method = {RequestMethod.OPTIONS, RequestMethod.PUT})
    public ResponseMessage addNetwork(@RequestBody NetworkModel networkModel,@RequestParam String type) {
        boolean a = networkHandler.create(networkModel,type);
        return new ResponseMessage<>(1, a ? a : HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @RequestMapping(value = "/", method = {RequestMethod.OPTIONS, RequestMethod.DELETE})
    public ResponseMessage deleteRemove(@RequestParam String name) {
        return new ResponseMessage<>(1, networkHandler.remove(name));
    }

}
