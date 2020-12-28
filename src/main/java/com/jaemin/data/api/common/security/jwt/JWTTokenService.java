package com.jaemin.data.api.common.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;

/**
 * A service to create JWT objects, this one is used when an exchange
 * provides basic authentication.
 * If authentication is successful, a token is added in the response
 */
@Slf4j
@Component
public class JWTTokenService {

    private static int expiredMinute;

    public JWTTokenService(@Value("${jwt.expired.minute}") int expiredMinute) {
        this.expiredMinute = expiredMinute;
    }


    /**
     * Returns a millisecond time representation 24hrs from now
     * to be used as the time the currently token will be valid
     *
     * @return Time representation 24 from now
     */
    private static long getExpiration() {

        return new Date().toInstant()
                .plus(Duration.ofMinutes(expiredMinute))
                .toEpochMilli();
    }
}
