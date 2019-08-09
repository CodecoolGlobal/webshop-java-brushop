package com.codecool.shop.password;

public class BCryptHashing {
    private String originalPassword = "password";
    private String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
    private boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);

    public BCryptHashing(String originalPassword) {
        this.originalPassword = originalPassword;
    }


    public boolean isMatched() {
        return matched;
    }

    public String getGeneratedSecuredPasswordHash() {
        return generatedSecuredPasswordHash;
    }
}
