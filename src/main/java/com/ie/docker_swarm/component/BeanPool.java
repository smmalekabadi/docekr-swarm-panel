package com.ie.docker_swarm.component;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanPool {
    public BeanPool() {

    }

    @Bean
    public DockerClient dockerClient() {
        DefaultDockerClientConfig.Builder config
                = DefaultDockerClientConfig.createDefaultConfigBuilder();
        return DockerClientBuilder
                .getInstance(config)
                .build();
    }
}
