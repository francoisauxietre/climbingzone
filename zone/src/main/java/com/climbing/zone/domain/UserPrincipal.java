package com.climbing.zone.domain;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private User user;

    @Autowired
    Logger logger;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList =new ArrayList<>();
        //list of permissions
        this.user.getAuthoritiesList().forEach(permission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
            grantedAuthorityList.add(grantedAuthority);
        });

        //list of roles
        this.user.getRolesList().forEach(permission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+permission);
            grantedAuthorityList.add(grantedAuthority);
        });

        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //TODO mettre cette valeur a jour si un utilisateur est block
    @Override
    public boolean isAccountNonLocked() {
        logger.warn(user.getUsername() +" is locked");
        return !this.user.isBlocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActive();
    }
}
