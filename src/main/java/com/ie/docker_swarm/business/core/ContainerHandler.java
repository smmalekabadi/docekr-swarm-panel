package com.ie.docker_swarm.business.core;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.TopContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ContainerHandler {
    DockerClient dockerClient;

    public ContainerHandler(DockerClient dockerClient) {

        this.dockerClient = dockerClient;
    }

    @PostConstruct
    public void init() {
//        DockerClient dockerClient = DockerClientBuilder.getInstance().build();
//        DefaultDockerClientConfig.Builder config
//                = DefaultDockerClientConfig.createDefaultConfigBuilder();
//        DockerClient dockerClient = DockerClientBuilder
//                .getInstance(config)
//                .build();
//        List<com.github.dockerjava.api.model.Service> a = dockerClient.listServicesCmd().exec();
//        dockerClient.createContainerCmd("hellow_world").with
//        dockerClient.conta
//        a.forEach( b-> System.out.println(b.getSpec().getMode().getReplicated().getReplicas()));
    }
    public String createContainer(String name ,String cmd){
        return dockerClient.createContainerCmd(name).withCmd().exec().getId();

    }
    public List<Container> getContainerList() {

        return dockerClient.listContainersCmd().withShowAll(true).exec();

    }
    public TopContainerResponse getTopContainer(String id){
        return dockerClient.topContainerCmd(id).exec();
    }

    public Boolean deleteContainer(String id) {
        try {
            dockerClient.removeContainerCmd(id).exec();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean setState(int state, String id) {
        try {
            switch (state) {
                case 0:
                    dockerClient.stopContainerCmd(id).exec();
                    break;
                case 1:
                    dockerClient.startContainerCmd(id).exec();
                    break;
                case 2:
                    dockerClient.restartContainerCmd(id).exec();
                    break;
                case 3:
                    dockerClient.pauseContainerCmd(id).exec();
                    break;
                case 4:
                    dockerClient.unpauseContainerCmd(id).exec();
                    break;
                case 9:
                    dockerClient.killContainerCmd(id).exec();
                    break;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
