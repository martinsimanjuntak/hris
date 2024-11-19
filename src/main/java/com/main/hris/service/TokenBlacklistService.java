package com.main.hris.service;

import com.main.hris.dto.response.ResponseStatusOnlyDto;
import com.main.hris.enumeration.ResponseDtoStatusEnum;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenBlacklistService {
    private final StringRedisTemplate stringRedisTemplate;

    public TokenBlacklistService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
    public ResponseStatusOnlyDto addTokenToBlacklist(String token, long expirationTimeInSeconds) {
        expirationTimeInSeconds = expirationTimeInSeconds * 1000;
        stringRedisTemplate.opsForValue().set(token, "blacklisted", expirationTimeInSeconds);
        return new ResponseStatusOnlyDto(ResponseDtoStatusEnum.SUCCESS);
    }

    public boolean isTokenBlacklisted(String token) {
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(token));
    }

}
