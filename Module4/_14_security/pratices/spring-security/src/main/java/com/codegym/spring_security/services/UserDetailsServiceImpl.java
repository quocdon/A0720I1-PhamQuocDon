package com.codegym.spring_security.services;

import com.codegym.spring_security.models.AppUser;
import com.codegym.spring_security.models.UserRole;
import com.codegym.spring_security.repositories.UserRepository;
import com.codegym.spring_security.repositories.UserRoleRepository;
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

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findById(username).orElse(null);

        if (appUser == null){
            throw new UsernameNotFoundException("User" + username + "was not found");
        }

        List<UserRole> userRoles = userRoleRepository.findByUser(appUser);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (userRoles != null){
            for (UserRole userRole : userRoles){
                grantedAuthorityList.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
            }
        }

        return (UserDetails) new User(appUser.getUsername(), appUser.getEncryptedPassword(), grantedAuthorityList);
    }
}
