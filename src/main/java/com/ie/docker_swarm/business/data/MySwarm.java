package com.ie.docker_swarm.business.data;

import com.github.dockerjava.api.model.Swarm;

public class MySwarm {
   Swarm swarm;
   long updatedAt2;

    public MySwarm(Swarm swarm, long updatedAt2) {
        this.swarm = swarm;
        this.updatedAt2 = updatedAt2;
    }

    public Swarm getSwarm() {
        return swarm;
    }

    public void setSwarm(Swarm swarm) {
        this.swarm = swarm;
    }

    public long getUpdatedAt2() {
        return updatedAt2;
    }

    public void setUpdatedAt2(long updatedAt2) {
        this.updatedAt2 = updatedAt2;
    }
}
