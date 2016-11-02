package ru.innopolis.master.ms1.university.dmd.showcase.web.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.User;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.UserService;
import ru.innopolis.master.ms1.university.dmd.showcase.web.security.jwt.JwtUser;

/**
 * Created by dalv on 01.11.2016.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findById(1l);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            //return JwtUserFactory.create(user);
        }
        //TODO:
        return new JwtUser(null, null);
    }
}
