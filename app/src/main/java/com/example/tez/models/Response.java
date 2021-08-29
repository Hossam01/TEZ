package com.example.tez.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response",strict = false)

public class Response {
    @Element(name = "auth")
    String auth;

    @Element(name = "user")
    User user;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
