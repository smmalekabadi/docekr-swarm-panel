package com.ie.docker_swarm.business.data.oauth;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by behzad on 5/27/18.
 */
@Entity
@Table(name = "oauth_code", schema = "public")
public class OauthCodeEntity {
    private String code;
    private byte[] authentication;
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "code", nullable = true, length = 256)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

        OauthCodeEntity that = (OauthCodeEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (!Arrays.equals(authentication, that.authentication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
