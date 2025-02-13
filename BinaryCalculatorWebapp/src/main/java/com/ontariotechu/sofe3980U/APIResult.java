package com.ontariotechu.sofe3980U;

public class APIResult {
    private String name;
    private String suggestedEmail;

    public APIResult(String fullName, String email) {
        this.name = fullName;
        this.suggestedEmail = email;
    }

    public String getName() {
        return name;
    }

    public String getSuggestedEmail() {
        return suggestedEmail;
    }
}