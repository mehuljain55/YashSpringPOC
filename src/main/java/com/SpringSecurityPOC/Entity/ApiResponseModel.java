package com.SpringSecurityPOC.Entity;

public class ApiResponseModel {
    private  User user;
    private String token;
    private String status;

    public ApiResponseModel(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public ApiResponseModel(User user, String token, String status) {
        this.user = user;
        this.token = token;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
