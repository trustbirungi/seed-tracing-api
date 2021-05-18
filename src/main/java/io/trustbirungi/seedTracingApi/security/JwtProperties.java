package io.trustbirungi.seedTracingApi.security;

public class JwtProperties {
    public static final String SECRET = "SomeSecretForJWTGeneration";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
