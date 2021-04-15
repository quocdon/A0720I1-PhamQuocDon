package com.codegym.furama_resort.services.impl;

import com.codegym.furama_resort.models.AppUser;
import com.codegym.furama_resort.models.UserRole;
import com.codegym.furama_resort.services.AppUserService;
import com.codegym.furama_resort.services.CustomerService;
import com.codegym.furama_resort.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AppUserService appUserService;

    @Autowired
    UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User " + username + " was not found");
        }
        Set<UserRole> userRoles = userRoleService.findByAppUser(appUser);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getAppRole().getName()));
            }
        }
        return (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
    }
}
