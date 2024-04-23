package com.texas.ecs.Ecommerce.service;

import com.texas.ecs.Ecommerce.enums.Role;
import com.texas.ecs.Ecommerce.model.User;
import com.texas.ecs.Ecommerce.repo.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User myDBUser = userRepo.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Bad Credential")
        );
        return new org.springframework.security.core.userdetails.User(
                myDBUser.getEmail(),
                myDBUser.getPassword(),
                getAuthorities(myDBUser.getRole())
        );
    }

    public Set<SimpleGrantedAuthority> getAuthorities(Role role){
        Set<SimpleGrantedAuthority> roleSet=new HashSet<>();
        SimpleGrantedAuthority myRole=new SimpleGrantedAuthority("ROLE_"+role.name());
        roleSet.add(myRole);
        return roleSet;
    }
}
