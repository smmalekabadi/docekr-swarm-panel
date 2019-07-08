package com.ie.docker_swarm.business.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.api.command.CreateVolumeResponse;
import com.github.dockerjava.api.command.InspectVolumeResponse;

import java.time.LocalDateTime;

public class VolumeModel {
    Long created;
    private String name;
    private String driver;
    private String mountpoint;
    public VolumeModel(CreateVolumeResponse createVolumeResponse,Long created) {
        this.created = created;
        this.driver=createVolumeResponse.getDriver();
        this.name=createVolumeResponse.getName();
        this.mountpoint=createVolumeResponse.getMountpoint();
    }
    public VolumeModel(InspectVolumeResponse createVolumeResponse, Long created) {
        this.created = created;
        this.driver=createVolumeResponse.getDriver();
        this.name=createVolumeResponse.getName();
        this.mountpoint=createVolumeResponse.getMountpoint();
    }

    public VolumeModel() {
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getMountpoint() {
        return mountpoint;
    }

    public void setMountpoint(String mountpoint) {
        this.mountpoint = mountpoint;
    }
}
