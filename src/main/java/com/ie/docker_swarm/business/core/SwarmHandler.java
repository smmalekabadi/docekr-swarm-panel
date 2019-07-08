package com.ie.docker_swarm.business.core;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Swarm;
import com.github.dockerjava.api.model.SwarmNode;
import com.github.dockerjava.api.model.SwarmSpec;
import com.ie.docker_swarm.business.data.MySwarm;
import com.ie.docker_swarm.business.data.StartModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwarmHandler {
    private DockerClient dockerClient;


    public SwarmHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public MySwarm getClusters() {
        return new MySwarm(dockerClient.inspectSwarmCmd().exec(),System.currentTimeMillis());

    }

    public boolean init(SwarmSpec swarmSpec) {
        try {
            dockerClient.initializeSwarmCmd(swarmSpec).exec();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSwarm(SwarmSpec swarmSpec, long version) {
        try {
            dockerClient.updateSwarmCmd(swarmSpec).withVersion(version).exec();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean join(){
        try {
            dockerClient.joinSwarmCmd().exec();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean leave(){
        try {
            dockerClient.leaveSwarmCmd().withForceEnabled(true).exec();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<SwarmNode> getNodes(){
        return dockerClient.listSwarmNodesCmd().exec();
    }
    public boolean updateNode(long version){
        try {
            dockerClient.updateSwarmNodeCmd().withVersion(version).exec();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public StartModel getInfo(){
        StartModel startModel = new StartModel();
        startModel.setContainerCountAll(dockerClient.listContainersCmd().withShowAll(true).exec().size());
        startModel.setImageCount(dockerClient.listImagesCmd().exec().size());
        startModel.setServiceCount(dockerClient.listServicesCmd().exec().size());
        startModel.setNetworkCount(dockerClient.listNetworksCmd().exec().size());
        startModel.setVolumsCount(dockerClient.listImagesCmd().exec().size());
        return startModel;
    }
}
