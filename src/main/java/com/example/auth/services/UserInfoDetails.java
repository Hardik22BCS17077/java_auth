package com.example.auth.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.auth.model.userinfo;

public class UserInfoDetails implements UserDetails{
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoDetails(userinfo user){
        this.username=user.getEmail();
        this.password=user.getPassword();
        this.authorities=List.of(user.getRoles().split(",")).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

public Collection<? extends GrantedAuthority> getAuthorities(){
    return authorities;
}

    public String getUsername(){
        return username;
    }
    public String getpassword(){
        return password;
    }
    public boolean isAccountExpired(){
        return false;
    }
    public boolean isAccountLocked(){
        return false;
    }

    public boolean isCredentialExpired(){
        return false;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    //public boolean 
}