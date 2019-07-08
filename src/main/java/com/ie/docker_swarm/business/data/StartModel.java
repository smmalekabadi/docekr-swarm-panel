package com.ie.docker_swarm.business.data;

public class StartModel {
    int serviceCount;
    int containerCountAll;
    int volumsCount;
    int imageCount;
    float imageSize;
    int networkCount;

    public StartModel() {
    }

    public int getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(int serviceCount) {
        this.serviceCount = serviceCount;
    }

    public int getContainerCountAll() {
        return containerCountAll;
    }

    public void setContainerCountAll(int containerCountAll) {
        this.containerCountAll = containerCountAll;
    }

    public int getVolumsCount() {
        return volumsCount;
    }

    public void setVolumsCount(int volumsCount) {
        this.volumsCount = volumsCount;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public float getImageSize() {
        return imageSize;
    }

    public void setImageSize(float imageSize) {
        this.imageSize = imageSize;
    }

    public int getNetworkCount() {
        return networkCount;
    }

    public void setNetworkCount(int networkCount) {
        this.networkCount = networkCount;
    }
}
