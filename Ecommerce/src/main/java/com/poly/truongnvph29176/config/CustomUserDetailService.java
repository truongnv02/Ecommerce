package com.poly.truongnvph29176.config;

import com.poly.truongnvph29176.entity.Account;
import com.poly.truongnvph29176.entity.Authority;
import com.poly.truongnvph29176.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findById(username);
        if(account == null) {
            throw new UsernameNotFoundException("Not Found");
        }
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Authority> authorities = account.getAuthorities();
        for(Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole().getId()));
        }
        return new CustomUserDetails(account, grantedAuthorities);
    }
}
