package com.ie.docker_swarm.business.core;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectVolumeResponse;
import com.github.dockerjava.api.command.ListVolumesResponse;
import com.ie.docker_swarm.business.data.VolumeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolumeHandler {
    private DockerClient dockerClient;

    public VolumeHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<VolumeModel> getVolumes() {
        ListVolumesResponse vol = dockerClient.listVolumesCmd().exec();
        List<VolumeModel> volumeModels = new ArrayList<>();
        for (InspectVolumeResponse volume : vol.getVolumes()) {
            volumeModels.add(new VolumeModel(volume, System.currentTimeMillis()));
        }
        return volumeModels;
    }

    public VolumeModel create(String name) {
        try {
            VolumeModel vol = new VolumeModel(dockerClient.createVolumeCmd()
                    .withName(name)
//                    .withDriver(volume.getDriver())
                    .exec(), System.currentTimeMillis());
            return vol;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean remove(String name) {
        try {
            dockerClient.removeVolumeCmd(name).exec();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public InspectVolumeResponse inspect(String name) {
        return dockerClient.inspectVolumeCmd(name).exec();
    }

}
