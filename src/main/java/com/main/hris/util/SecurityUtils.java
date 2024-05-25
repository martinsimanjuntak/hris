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
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof TokenUserDetails) {
                return (TokenUserDetails) principal;
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                        "Principal is not an instance of TokenUserDetails");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication is null");
        }
    }

    public static String getUsername() throws ResponseStatusException {
        return getUserDetails().getUsername();
    }
}
