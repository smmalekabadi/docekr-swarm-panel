package com.ie.docker_swarm.component;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanPool {
    public BeanPool() {

    }
    @Bean
    public RestTemplate noProxyRestTemplate() {
        return new RestTemplate();
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
