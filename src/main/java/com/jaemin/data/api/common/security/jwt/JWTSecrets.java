package com.jaemin.data.api.common.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A a static class that abstracts a secret provider
 * Later this one can be changed with a better approach
 */
@Component
public class JWTSecrets {

    /**
     * A default secret for development purposes.
     */
    public static String DEFAULT_SECRET;

    public JWTSecrets(@Value("${jwt.secret}") String secret) {
        this.DEFAULT_SECRET = secret;
    }


}
