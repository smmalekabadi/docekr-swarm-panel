package com.ie.docker_swarm.business.core;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Network;
import com.ie.docker_swarm.business.data.NetworkModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkHandler {
    private DockerClient dockerClient;

    public NetworkHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Network> getNetworks() {
        return dockerClient.listNetworksCmd().exec();
    }

    public boolean create(NetworkModel networkModel) {
        try {
            dockerClient.createNetworkCmd().withName(networkModel.getName()).withIpam(new Network.Ipam().withConfig( new Network.Ipam.Config()
                    .withSubnet(networkModel.getSubnet())
                    .withIpRange(networkModel.getIpRange()))
            ).withDriver("bridge");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean remove(String name){
        try {
//            dockerClient.listSwarmNodesCmd().
            dockerClient.removeNetworkCmd(name);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
