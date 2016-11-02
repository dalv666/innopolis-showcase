package ru.innopolis.master.ms1.university.dmd.showcase.web.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.User;

import java.util.Collection;
import java.util.Date;


public class JwtUser implements UserDetails {

    private User user;
    private Date lastPasswordResetDate;

    public JwtUser(User user, Date lastPasswordResetDate) {
        this.user = user;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getLogin();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
