package com.ie.docker_swarm.business.core;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectVolumeResponse;
import com.github.dockerjava.api.command.ListVolumesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeHandler {
    private DockerClient dockerClient;

    public VolumeHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }
    public List<InspectVolumeResponse> getVolumes(){
        ListVolumesResponse vol = dockerClient.listVolumesCmd().exec();
        return vol.getVolumes();
    }
    public String create(String name){
        return dockerClient.createVolumeCmd().withName(name).exec().getName();
    }
    public boolean remove(String name){
        try {
            dockerClient.removeVolumeCmd(name).exec();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public InspectVolumeResponse inspect(String name){
        return dockerClient.inspectVolumeCmd(name).exec();
    }

}
