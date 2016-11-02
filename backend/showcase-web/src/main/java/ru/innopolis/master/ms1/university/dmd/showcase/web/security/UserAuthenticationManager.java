package ru.innopolis.master.ms1.university.dmd.showcase.web.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.innopolis.master.ms1.university.dmd.showcase.web.security.jwt.JwtUser;

@Component
public class UserAuthenticationManager implements AuthenticationManager {


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final Object details = authentication.getDetails();
/*        if (details instanceof CustomUserDetail) {
            CustomUserDetail customUserDetail = (CustomUserDetail) details;
            if (customUserDetail.getUser().getIsAdmin()) {
                return new CustomAuthentication(true, customUserDetail);
            }
        }*/
        throw new BadCredentialsException("Bad Credentials");
    }
}
