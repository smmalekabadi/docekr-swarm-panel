package com.ie.docker_swarm.business.core;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.command.BuildImageResultCallback;
import com.github.dockerjava.core.command.PullImageResultCallback;
import com.github.dockerjava.core.command.PushImageResultCallback;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ImageHandler {
    private DockerClient dockerClient;

    public ImageHandler(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Image> imageList() {
        return dockerClient.listImagesCmd().exec();
    }

    public boolean pullImage(String name) {
        try {
            dockerClient.pullImageCmd(name).exec(new PullImageResultCallback()).awaitCompletion(30, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean pushIamge(String name) {
        try {
            dockerClient.pushImageCmd(name).exec(new PushImageResultCallback());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public String buildImage(String dir) {
        return dockerClient.buildImageCmd().withPull(true).withDockerfile(new File(dir)).exec(new BuildImageResultCallback()).awaitImageId();
    }

    public boolean removeImage(String id) {
        try {
            dockerClient.removeImageCmd(id).withImageId(id).exec();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<SearchItem> searchIamges(String search){
        return dockerClient.searchImagesCmd(search).exec();
    }
}
