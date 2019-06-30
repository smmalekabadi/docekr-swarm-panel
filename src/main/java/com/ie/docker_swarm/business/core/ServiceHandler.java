package com.ie.docker_swarm.business.core;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.ServiceSpec;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceHandler {
    private DockerClient dockerClient;

    public ServiceHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public String createService(ServiceSpec serviceSpec) {
        try {
            return dockerClient.createServiceCmd(serviceSpec).exec().getId();
        }catch (Exception e){
            e.printStackTrace();
            return "something went wrong";
        }
    }

    public Boolean updateService(String id, ServiceSpec serviceSpec,Long version) {
        try {
            dockerClient.updateServiceCmd(id, serviceSpec).withVersion(version).exec();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteService(String id) {
        try {
            dockerClient.removeServiceCmd(id).exec();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<com.github.dockerjava.api.model.Service> getServiceList() {
        return dockerClient.listServicesCmd().exec();
    }
}
