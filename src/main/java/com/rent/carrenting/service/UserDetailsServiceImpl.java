package com.rent.carrenting.service;

import com.rent.carrenting.models.Role;
import com.rent.carrenting.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<com.rent.carrenting.models.User> optionalUser = userRepository.findByUsername(userName);
        if(optionalUser.isPresent()) {
            com.rent.carrenting.models.User user = optionalUser.get();

            List<String> roleList = new ArrayList<String>();
            for(Role role:user.getRoles()) {
                roleList.add(role.getName());
            }

            return User.builder()
                    .username(user.getUsername())
                    //change here to store encoded password in db
                    .password( user.getPassword() )
                    .disabled(user.isDisabled())
                    .accountExpired(user.isAccountExpired())
                    .accountLocked(user.isAccountLocked())
                    .credentialsExpired(user.isCredentialsExpired())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }
}
