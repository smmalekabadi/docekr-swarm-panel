package com.ie.docker_swarm.component;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JdbcTokenStore extends org.springframework.security.oauth2.provider.token.store.JdbcTokenStore {
    private ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(JdbcTokenStore.class);

    public JdbcTokenStore(DataSource dataSource, ObjectMapper objectMapper) {
        super(dataSource);
        this.objectMapper = objectMapper;
    }
    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        OAuth2AccessToken accessToken = null;

        try {
            accessToken = new DefaultOAuth2AccessToken(tokenValue);
        }
        catch (EmptyResultDataAccessException e) {
            if (logger.isInfoEnabled()) {
                logger.info("Failed to find access token for token "+tokenValue);
            }
        }
        catch (IllegalArgumentException e) {
            logger.warn("Failed to deserialize access token for " +tokenValue,e);
            removeAccessToken(tokenValue);
        }

        return accessToken;
    }

    public static ConcurrentMap<OAuth2RefreshToken, Boolean> duplicateRefreshMap = new ConcurrentHashMap<>();

//    @Override
//    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
//        logger.info("Refreshing with {}", token.getRefreshToken());
//        if(duplicateRefreshMap.get(token.getRefreshToken()) != null){
//            logger.warn("Catched duplicate refresh for {}", token.getRefreshToken());
//            return;
//        }
//
//        duplicateRefreshMap.put(token.getRefreshToken(), true);
//        super.storeAccessToken(token, authentication);
//    }

    @Override
    protected byte[] serializeAccessToken(OAuth2AccessToken token) {
        try {
            return objectMapper.writeValueAsBytes(token);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected byte[] serializeRefreshToken(OAuth2RefreshToken token) {
        try {
            return objectMapper.writeValueAsBytes(token);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected byte[] serializeAuthentication(OAuth2Authentication authentication) {
        try {
            return objectMapper.writeValueAsBytes(authentication);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected OAuth2AccessToken deserializeAccessToken(byte[] token) {
        try {
            return objectMapper.readValue(new String(token), OAuth2AccessToken.class );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected OAuth2RefreshToken deserializeRefreshToken(byte[] token) {
        try {
            return objectMapper.readValue(new String(token), DefaultExpiringOAuth2RefreshToken.class );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected OAuth2Authentication deserializeAuthentication(byte[] authentication) {
        try {
            return objectMapper.readValue(new String(authentication), OAuth2Authentication.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
