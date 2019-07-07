package com.ie.docker_swarm.business.verification;

import org.codehaus.jackson.annotate.JsonProperty;

public class TokenModel {
    private String accessToken;
    private String refreshToken;
    private String expiresIn;
    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    @JsonProperty
    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}
