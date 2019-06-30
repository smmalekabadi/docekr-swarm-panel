package com.ie.docker_swarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableScheduling
@SpringBootApplication
@EnableResourceServer
public class DockerSwarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerSwarmApplication.class, args);
    }

}
