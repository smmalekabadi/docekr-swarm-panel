package com.ie.docker_swarm.business.data;

public class NetworkModel {
    private String name;
    private String ipRange;
    private String subnet;

    public NetworkModel() {
    }

    public NetworkModel(String name, String ipRange, String subnet) {
        this.name = name;
        this.ipRange = ipRange;
        this.subnet = subnet;
    }

    public NetworkModel(String name, String subnet) {
        this.name = name;
        this.subnet = subnet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpRange() {
        return ipRange;
    }

    public void setIpRange(String ipRange) {
        this.ipRange = ipRange;
    }

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }
}
