package com.ie.docker_swarm.business.data.oauth;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by behzad on 5/27/18.
 */
@Entity
@Table(name = "oauth_refresh_token", schema = "public")
public class OauthRefreshTokenEntity {
    private String tokenId;
    private byte[] token;
    private byte[] authentication;

    @Id
    @Basic
    @Column(name = "token_id", nullable = true, length = 256)
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    @Basic
    @Column(name = "token", nullable = true)
    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    @Basic
    @Column(name = "authentication", nullable = true)
    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OauthRefreshTokenEntity that = (OauthRefreshTokenEntity) o;

        if (tokenId != null ? !tokenId.equals(that.tokenId) : that.tokenId != null) return false;
        if (!Arrays.equals(token, that.token)) return false;
        if (!Arrays.equals(authentication, that.authentication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tokenId != null ? tokenId.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(token);
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
