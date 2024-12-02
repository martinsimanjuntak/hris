package com.main.hris.service.token;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenBlacklistService {
    private static final String BLACKLIST_PREFIX = "BLACKLIST:";
    private final RedisTemplate<String, String> redisTemplate;

    public TokenBlacklistService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Menyimpan token yang dibatalkan di Redis
    public void blacklistToken(String token) {
        redisTemplate.opsForValue().set(BLACKLIST_PREFIX + token, token, 1, TimeUnit.DAYS);
    }

    // Mengecek apakah token ada di blacklist
    public boolean isTokenBlacklisted(String token) {
        return redisTemplate.hasKey(BLACKLIST_PREFIX + token);
    }

}
