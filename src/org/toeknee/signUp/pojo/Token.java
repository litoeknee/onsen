package org.toeknee.signUp.pojo;

/**
 * Created by toeknee on 11/26/15.
 */

public class Token {
    private String accessToken;
    // expires time
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
