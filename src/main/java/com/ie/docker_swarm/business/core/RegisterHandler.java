package com.ie.docker_swarm.business.core;

import com.ie.docker_swarm.business.verification.LoginToken;
import com.ie.docker_swarm.business.verification.TokenModel;
import com.sun.net.httpserver.Headers;
import org.springframework.http.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterHandler {
    private RestTemplate restTemplate;

    public RegisterHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String obtainAccessToken(String username, String password) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("http://127.0.0.1:8080" +"/oauth/token/");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("username", username);
        map.add("password", password);
        map.add("grant_type", "password");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + new String(Base64.encode("android_app:secret".getBytes())));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        try {
            ResponseEntity<LoginToken> loginToken = restTemplate.exchange(
                    builder.build().encode().toUri(),
                    HttpMethod.POST,
                    new HttpEntity<>(map, headers),
                    LoginToken.class
            );
            System.out.println(loginToken.getBody().getAccessToken());
            return loginToken.getBody().getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

//    public String newobtainAccessToken(String username, String password) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("grant_type", "password");
//        params.put("client_id", "mobile");
//        params.put("username", username);
//        params.put("password", password);
//        RestAssured.given().auth().preemptive()
//                .basic("mobile", "secret").and().with().params(params).when()
//                .post("http://localhost:8081/spring-security-oauth-server/oauth/token");
////        return response.jsonPath().getString("access_token");
//        return "a";
//    }
}
