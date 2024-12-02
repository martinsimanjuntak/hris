package com.main.hris.util;

import com.main.hris.dto.other.TokenUserDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class SecurityUtils {

    public static TokenUserDetails getUserDetails() throws ResponseStatusException {

        return getUserDetails(SecurityContextHolder.getContext().getAuthentication());
    }

    public static TokenUserDetails getUserDetails(Authentication authentication) throws ResponseStatusException {
        if (authentication != null && authentication.getPrincipal() instanceof TokenUserDetails) {
            return (TokenUserDetails) authentication.getPrincipal();
        }
        else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication is nullLLL"+authentication.getPrincipal().getClass().getName());
        }
    }

    public static String getUsername() throws ResponseStatusException {
        return getUserDetails().getUsername();
    }
}
