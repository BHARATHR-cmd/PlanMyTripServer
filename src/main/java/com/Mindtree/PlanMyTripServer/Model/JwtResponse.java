package com.Mindtree.PlanMyTripServer.Model;

public class JwtResponse {
    String token;

    public String getToken() {
        return token;
    }

    public JwtResponse() {
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}
